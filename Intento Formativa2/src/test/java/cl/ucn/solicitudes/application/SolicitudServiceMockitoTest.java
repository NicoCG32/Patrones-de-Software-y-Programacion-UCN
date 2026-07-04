package cl.ucn.solicitudes.application;

import cl.ucn.solicitudes.domain.model.EstadoSolicitud;
import cl.ucn.solicitudes.domain.model.Estudiante;
import cl.ucn.solicitudes.domain.model.Solicitud;
import cl.ucn.solicitudes.domain.service.NotificadorExterno;
import cl.ucn.solicitudes.domain.service.PublicadorEventosSolicitud;
import cl.ucn.solicitudes.infra.jpa.SolicitudRepository;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class SolicitudServiceMockitoTest {

    @Test
    public void cambiarEstadoDebePublicarEventoYNotificar() throws Exception {
        Estudiante estudiante = new Estudiante("Ana Torres", "ana@universidad.cl");
        Solicitud solicitud = new Solicitud(estudiante, "Certificado", "Solicitud válida");

        asignarId(solicitud, 10L);

        SolicitudRepository repository = mock(SolicitudRepository.class);
        PublicadorEventosSolicitud publicador = mock(PublicadorEventosSolicitud.class);
        NotificadorExterno notificador = mock(NotificadorExterno.class);

        when(repository.buscarPorId(10L)).thenReturn(Optional.of(solicitud));
        when(repository.guardar(any(Solicitud.class))).thenAnswer(invocation -> invocation.getArgument(0));

        SolicitudService service = new SolicitudService(publicador, notificador, repository);

        service.cambiarEstado(10L, EstadoSolicitud.EN_REVISION);

        verify(repository).guardar(any(Solicitud.class));
        verify(publicador).publicar(any(EventoCambioEstadoSolicitud.class));
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
