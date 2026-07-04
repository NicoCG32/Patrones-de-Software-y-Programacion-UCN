package cl.ucn.solicitudes.controller;

import cl.ucn.solicitudes.application.SolicitudService;
import cl.ucn.solicitudes.domain.model.EstadoSolicitud;
import cl.ucn.solicitudes.domain.model.Estudiante;
import cl.ucn.solicitudes.domain.model.Solicitud;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SolicitudControllerTest {

    @Test
    public void controladorDebeDelegarRegistroDeEstudiante() {
        SolicitudService service = mock(SolicitudService.class);
        Estudiante estudiante = new Estudiante("Ana Torres", "ana@universidad.cl");
        when(service.registrarEstudiante("Ana Torres", "ana@universidad.cl"))
                .thenReturn(estudiante);

        SolicitudController controller = new SolicitudController(service);

        Estudiante resultado = controller.registrarEstudiante(
                "Ana Torres",
                "ana@universidad.cl"
        );

        assertEquals(estudiante, resultado);
        verify(service).registrarEstudiante("Ana Torres", "ana@universidad.cl");
    }

    @Test
    public void controladorDebeDelegarCreacionDeSolicitud() {
        SolicitudService service = mock(SolicitudService.class);
        Estudiante estudiante = new Estudiante("Ana Torres", "ana@universidad.cl");
        Solicitud solicitud = new Solicitud(estudiante, "Certificado", "Solicitud valida");

        when(service.crearSolicitud(1L, "Certificado", "Solicitud valida"))
                .thenReturn(solicitud);

        SolicitudController controller = new SolicitudController(service);

        Solicitud resultado = controller.crearSolicitud(
                1L,
                "Certificado",
                "Solicitud valida"
        );

        assertEquals(solicitud, resultado);
        verify(service).crearSolicitud(1L, "Certificado", "Solicitud valida");
    }

    @Test
    public void controladorDebeDelegarCambioDeEstado() {
        SolicitudService service = mock(SolicitudService.class);
        Estudiante estudiante = new Estudiante("Ana Torres", "ana@universidad.cl");
        Solicitud solicitud = new Solicitud(estudiante, "Certificado", "Solicitud valida");

        when(service.cambiarEstado(2L, EstadoSolicitud.EN_REVISION))
                .thenReturn(solicitud);

        SolicitudController controller = new SolicitudController(service);

        Solicitud resultado = controller.cambiarEstado(2L, EstadoSolicitud.EN_REVISION);

        assertEquals(solicitud, resultado);
        verify(service).cambiarEstado(2L, EstadoSolicitud.EN_REVISION);
    }
}
