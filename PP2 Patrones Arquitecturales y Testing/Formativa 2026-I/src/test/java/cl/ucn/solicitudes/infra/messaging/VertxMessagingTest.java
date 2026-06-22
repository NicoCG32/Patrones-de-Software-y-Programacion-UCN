package cl.ucn.solicitudes.infra.messaging;

import cl.ucn.solicitudes.application.EventoCambioEstadoSolicitud;
import cl.ucn.solicitudes.domain.model.EstadoSolicitud;
import cl.ucn.solicitudes.domain.model.HistorialEvento;
import cl.ucn.solicitudes.domain.repository.HistorialEventoPort;
import io.vertx.core.Vertx;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VertxMessagingTest {

    @Test
    public void cambioDeEstadoDebeLlegarAlReceptorDeHistorial() throws Exception {
        Vertx vertx = Vertx.vertx();
        List<HistorialEvento> recibidos = new ArrayList<>();
        CountDownLatch recibido = new CountDownLatch(1);
        CountDownLatch desplegado = new CountDownLatch(1);

        HistorialEventoPort historialPort = evento -> {
            recibidos.add(evento);
            recibido.countDown();
            return evento;
        };

        vertx.deployVerticle(
                new HistorialEventosVerticle(historialPort),
                resultado -> desplegado.countDown()
        );

        try {
            assertTrue(desplegado.await(5, TimeUnit.SECONDS));

            VertxPublicadorEventosSolicitud publicador =
                    new VertxPublicadorEventosSolicitud(vertx);

            publicador.publicar(new EventoCambioEstadoSolicitud(
                    15L,
                    EstadoSolicitud.PENDIENTE,
                    EstadoSolicitud.EN_REVISION,
                    LocalDateTime.now()
            ));

            assertTrue(recibido.await(5, TimeUnit.SECONDS));
            assertEquals(1, recibidos.size());
            assertEquals(15L, recibidos.get(0).getSolicitudId().longValue());
            assertEquals(EstadoSolicitud.PENDIENTE, recibidos.get(0).getEstadoAnterior());
            assertEquals(EstadoSolicitud.EN_REVISION, recibidos.get(0).getEstadoNuevo());
            assertEquals("HistorialEventosVerticle", recibidos.get(0).getRecibidoPor());
        } finally {
            CountDownLatch cerrado = new CountDownLatch(1);
            vertx.close(resultado -> cerrado.countDown());
            cerrado.await(5, TimeUnit.SECONDS);
        }
    }
}
