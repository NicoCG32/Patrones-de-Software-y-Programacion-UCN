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
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SolicitudServiceMockitoTest {

    @Test
    public void registrarEstudianteDebeGuardarEstudianteValido() {
        EstudiantePort estudiantePort = mock(EstudiantePort.class);
        SolicitudPort solicitudPort = mock(SolicitudPort.class);
        PublicadorEventosSolicitud publicador = mock(PublicadorEventosSolicitud.class);
        NotificadorExterno notificador = mock(NotificadorExterno.class);

        when(estudiantePort.guardar(any(Estudiante.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        SolicitudService service = new SolicitudService(
                estudiantePort,
                solicitudPort,
                publicador,
                notificador
        );

        Estudiante estudiante = service.registrarEstudiante("Ana Torres", "ana@universidad.cl");

        assertEquals("Ana Torres", estudiante.getNombre());
        verify(estudiantePort).guardar(any(Estudiante.class));
    }

    @Test
    public void crearSolicitudDebeBuscarEstudianteYGuardarSolicitud() {
        Estudiante estudiante = new Estudiante("Ana Torres", "ana@universidad.cl");
        EstudiantePort estudiantePort = mock(EstudiantePort.class);
        SolicitudPort solicitudPort = mock(SolicitudPort.class);
        PublicadorEventosSolicitud publicador = mock(PublicadorEventosSolicitud.class);
        NotificadorExterno notificador = mock(NotificadorExterno.class);

        when(estudiantePort.buscarPorId(1L)).thenReturn(Optional.of(estudiante));
        when(solicitudPort.guardar(any(Solicitud.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        SolicitudService service = new SolicitudService(
                estudiantePort,
                solicitudPort,
                publicador,
                notificador
        );

        Solicitud solicitud = service.crearSolicitud(1L, "Certificado", "Solicitud valida");

        assertEquals(estudiante, solicitud.getEstudiante());
        assertEquals("Certificado", solicitud.getTipo());
        verify(solicitudPort).guardar(any(Solicitud.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void crearSolicitudDebeRechazarEstudianteInexistente() {
        EstudiantePort estudiantePort = mock(EstudiantePort.class);
        SolicitudPort solicitudPort = mock(SolicitudPort.class);
        PublicadorEventosSolicitud publicador = mock(PublicadorEventosSolicitud.class);
        NotificadorExterno notificador = mock(NotificadorExterno.class);

        when(estudiantePort.buscarPorId(99L)).thenReturn(Optional.empty());

        SolicitudService service = new SolicitudService(
                estudiantePort,
                solicitudPort,
                publicador,
                notificador
        );

        service.crearSolicitud(99L, "Certificado", "Solicitud valida");
    }

    @Test
    public void cambiarEstadoDebeGuardarPublicarEventoYNotificar() throws Exception {
        Estudiante estudiante = new Estudiante("Ana Torres", "ana@universidad.cl");
        Solicitud solicitud = new Solicitud(estudiante, "Certificado", "Solicitud valida");
        asignarId(solicitud, 10L);

        EstudiantePort estudiantePort = mock(EstudiantePort.class);
        SolicitudPort solicitudPort = mock(SolicitudPort.class);
        PublicadorEventosSolicitud publicador = mock(PublicadorEventosSolicitud.class);
        NotificadorExterno notificador = mock(NotificadorExterno.class);

        when(solicitudPort.buscarPorId(10L)).thenReturn(Optional.of(solicitud));
        when(solicitudPort.guardar(any(Solicitud.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        SolicitudService service = new SolicitudService(
                estudiantePort,
                solicitudPort,
                publicador,
                notificador
        );

        service.cambiarEstado(10L, EstadoSolicitud.EN_REVISION);

        ArgumentCaptor<EventoCambioEstadoSolicitud> captor =
                ArgumentCaptor.forClass(EventoCambioEstadoSolicitud.class);

        verify(solicitudPort).guardar(any(Solicitud.class));
        verify(publicador).publicar(captor.capture());
        verify(notificador).enviarCorreo(
                eq("ana@universidad.cl"),
                anyString(),
                contains("EN_REVISION")
        );

        assertEquals(10L, captor.getValue().getSolicitudId().longValue());
        assertEquals(EstadoSolicitud.PENDIENTE, captor.getValue().getEstadoAnterior());
        assertEquals(EstadoSolicitud.EN_REVISION, captor.getValue().getEstadoNuevo());
    }

    @Test(expected = IllegalArgumentException.class)
    public void cambiarEstadoDebeRechazarSolicitudInexistente() {
        EstudiantePort estudiantePort = mock(EstudiantePort.class);
        SolicitudPort solicitudPort = mock(SolicitudPort.class);
        PublicadorEventosSolicitud publicador = mock(PublicadorEventosSolicitud.class);
        NotificadorExterno notificador = mock(NotificadorExterno.class);

        when(solicitudPort.buscarPorId(99L)).thenReturn(Optional.empty());

        SolicitudService service = new SolicitudService(
                estudiantePort,
                solicitudPort,
                publicador,
                notificador
        );

        try {
            service.cambiarEstado(99L, EstadoSolicitud.EN_REVISION);
        } finally {
            verify(solicitudPort, never()).guardar(any(Solicitud.class));
            verify(publicador, never()).publicar(any(EventoCambioEstadoSolicitud.class));
            verify(notificador, never()).enviarCorreo(anyString(), anyString(), anyString());
        }
    }

    @Test(expected = IllegalStateException.class)
    public void cambiarEstadoNoDebeNotificarSiLaSolicitudYaEstaFinalizada() throws Exception {
        Estudiante estudiante = new Estudiante("Ana Torres", "ana@universidad.cl");
        Solicitud solicitud = new Solicitud(estudiante, "Certificado", "Solicitud valida");
        solicitud.cambiarEstado(EstadoSolicitud.APROBADA);
        asignarId(solicitud, 20L);

        EstudiantePort estudiantePort = mock(EstudiantePort.class);
        SolicitudPort solicitudPort = mock(SolicitudPort.class);
        PublicadorEventosSolicitud publicador = mock(PublicadorEventosSolicitud.class);
        NotificadorExterno notificador = mock(NotificadorExterno.class);

        when(solicitudPort.buscarPorId(20L)).thenReturn(Optional.of(solicitud));

        SolicitudService service = new SolicitudService(
                estudiantePort,
                solicitudPort,
                publicador,
                notificador
        );

        try {
            service.cambiarEstado(20L, EstadoSolicitud.EN_REVISION);
        } finally {
            verify(solicitudPort, never()).guardar(any(Solicitud.class));
            verify(publicador, never()).publicar(any(EventoCambioEstadoSolicitud.class));
            verify(notificador, never()).enviarCorreo(anyString(), anyString(), anyString());
        }
    }

    private void asignarId(Solicitud solicitud, Long id) throws Exception {
        Field field = Solicitud.class.getDeclaredField("id");
        field.setAccessible(true);
        field.set(solicitud, id);
    }
}
