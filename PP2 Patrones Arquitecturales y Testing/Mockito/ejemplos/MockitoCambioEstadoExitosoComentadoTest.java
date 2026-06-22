package cl.ucn.solicitudes.application;

import cl.ucn.solicitudes.domain.model.EstadoSolicitud;
import cl.ucn.solicitudes.domain.model.Estudiante;
import cl.ucn.solicitudes.domain.model.Solicitud;
import cl.ucn.solicitudes.domain.repository.EstudiantePort;
import cl.ucn.solicitudes.domain.repository.SolicitudPort;
import cl.ucn.solicitudes.domain.service.NotificadorExterno;
import cl.ucn.solicitudes.domain.service.PublicadorEventosSolicitud;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.lang.reflect.Field;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Ejemplo 1: Mockito en un caso exitoso.
 *
 * Objetivo:
 * Probar SolicitudService sin base de datos, sin Vert.x real y sin correo real.
 */
public class MockitoCambioEstadoExitosoComentadoTest {

    @Test
    public void cambiarEstadoDebeGuardarPublicarYNotificar() throws Exception {
        // Arrange: entidad real del dominio.
        Estudiante estudiante = new Estudiante("Ana Torres", "ana@universidad.cl");
        Solicitud solicitud = new Solicitud(estudiante, "Certificado", "Solicitud válida");
        asignarId(solicitud, 10L);

        // Arrange: dependencias falsas.
        EstudiantePort estudiantePort = mock(EstudiantePort.class);
        SolicitudPort solicitudPort = mock(SolicitudPort.class);
        PublicadorEventosSolicitud publicador = mock(PublicadorEventosSolicitud.class);
        NotificadorExterno notificador = mock(NotificadorExterno.class);

        // El repositorio simulado responde que la solicitud sí existe.
        when(solicitudPort.buscarPorId(10L)).thenReturn(Optional.of(solicitud));

        // El guardado simulado retorna la misma solicitud recibida.
        when(solicitudPort.guardar(any(Solicitud.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // Unidad bajo prueba.
        SolicitudService service = new SolicitudService(
                estudiantePort,
                solicitudPort,
                publicador,
                notificador
        );

        // Act: se ejecuta el caso de uso.
        service.cambiarEstado(10L, EstadoSolicitud.EN_REVISION);

        // Assert: se verifica que se guardó.
        verify(solicitudPort).guardar(any(Solicitud.class));

        // Assert: se captura el evento publicado.
        ArgumentCaptor<EventoCambioEstadoSolicitud> captor =
                ArgumentCaptor.forClass(EventoCambioEstadoSolicitud.class);
        verify(publicador).publicar(captor.capture());

        // Assert: el evento debe representar la transición correcta.
        assertEquals(10L, captor.getValue().getSolicitudId().longValue());
        assertEquals(EstadoSolicitud.PENDIENTE, captor.getValue().getEstadoAnterior());
        assertEquals(EstadoSolicitud.EN_REVISION, captor.getValue().getEstadoNuevo());

        // Assert: se verifica el correo sin enviar un correo real.
        verify(notificador).enviarCorreo(
                eq("ana@universidad.cl"),
                anyString(),
                contains("EN_REVISION")
        );
    }

    private void asignarId(Solicitud solicitud, Long id) throws Exception {
        Field field = Solicitud.class.getDeclaredField("id");
        field.setAccessible(true);
        field.set(solicitud, id);
    }
}

