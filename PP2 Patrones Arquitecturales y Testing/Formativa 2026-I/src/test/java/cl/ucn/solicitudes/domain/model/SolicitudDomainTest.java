package cl.ucn.solicitudes.domain.model;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SolicitudDomainTest {

    @Test
    public void estudianteValidoDebeGuardarNombreYCorreo() {
        Estudiante estudiante = new Estudiante("Ana Torres", "ana@universidad.cl");

        assertEquals("Ana Torres", estudiante.getNombre());
        assertEquals("ana@universidad.cl", estudiante.getCorreo());
    }

    @Test(expected = IllegalArgumentException.class)
    public void estudianteNoDebeAceptarNombreVacio() {
        new Estudiante(" ", "ana@universidad.cl");
    }

    @Test(expected = IllegalArgumentException.class)
    public void estudianteNoDebeAceptarCorreoVacio() {
        new Estudiante("Ana Torres", " ");
    }

    @Test
    public void solicitudValidaDebeGuardarSusDatos() {
        Estudiante estudiante = new Estudiante("Ana Torres", "ana@universidad.cl");

        Solicitud solicitud = new Solicitud(
                estudiante,
                "Certificado",
                "Solicita certificado de alumno regular"
        );

        assertEquals(estudiante, solicitud.getEstudiante());
        assertEquals("Certificado", solicitud.getTipo());
        assertEquals("Solicita certificado de alumno regular", solicitud.getDescripcion());
        assertEquals(EstadoSolicitud.PENDIENTE, solicitud.getEstado());
        assertNotNull(solicitud.getFechaCreacion());
    }

    @Test(expected = IllegalArgumentException.class)
    public void solicitudNoDebeAceptarEstudianteNulo() {
        new Solicitud(null, "Certificado", "Solicitud valida");
    }

    @Test(expected = IllegalArgumentException.class)
    public void solicitudNoDebeAceptarTipoVacio() {
        Estudiante estudiante = new Estudiante("Ana Torres", "ana@universidad.cl");

        new Solicitud(estudiante, " ", "Solicitud valida");
    }

    @Test(expected = IllegalArgumentException.class)
    public void solicitudNoDebeAceptarDescripcionVacia() {
        Estudiante estudiante = new Estudiante("Ana Torres", "ana@universidad.cl");

        new Solicitud(estudiante, "Certificado", " ");
    }

    @Test
    public void solicitudDebeCambiarEstadoValido() {
        Estudiante estudiante = new Estudiante("Ana Torres", "ana@universidad.cl");
        Solicitud solicitud = new Solicitud(estudiante, "Certificado", "Solicitud valida");

        solicitud.cambiarEstado(EstadoSolicitud.EN_REVISION);

        assertEquals(EstadoSolicitud.EN_REVISION, solicitud.getEstado());
        assertNotNull(solicitud.getFechaActualizacion());
    }

    @Test(expected = IllegalArgumentException.class)
    public void solicitudNoDebeAceptarEstadoNulo() {
        Estudiante estudiante = new Estudiante("Ana Torres", "ana@universidad.cl");
        Solicitud solicitud = new Solicitud(estudiante, "Certificado", "Solicitud valida");

        solicitud.cambiarEstado(null);
    }

    @Test(expected = IllegalStateException.class)
    public void solicitudFinalizadaNoDebeCambiarEstado() {
        Estudiante estudiante = new Estudiante("Ana Torres", "ana@universidad.cl");
        Solicitud solicitud = new Solicitud(estudiante, "Certificado", "Solicitud valida");

        solicitud.cambiarEstado(EstadoSolicitud.APROBADA);
        solicitud.cambiarEstado(EstadoSolicitud.EN_REVISION);
    }

    @Test
    public void estadoSolicitudDebeDistinguirEstadosFinales() {
        assertFalse(EstadoSolicitud.PENDIENTE.esFinal());
        assertFalse(EstadoSolicitud.EN_REVISION.esFinal());
        assertTrue(EstadoSolicitud.APROBADA.esFinal());
        assertTrue(EstadoSolicitud.RECHAZADA.esFinal());
    }

    @Test
    public void historialEventoDebeExponerSusDatos() {
        LocalDateTime fecha = LocalDateTime.now();

        HistorialEvento evento = new HistorialEvento(
                5L,
                EstadoSolicitud.PENDIENTE,
                EstadoSolicitud.EN_REVISION,
                fecha,
                "test"
        );

        assertEquals(5L, evento.getSolicitudId().longValue());
        assertEquals(EstadoSolicitud.PENDIENTE, evento.getEstadoAnterior());
        assertEquals(EstadoSolicitud.EN_REVISION, evento.getEstadoNuevo());
        assertEquals(fecha, evento.getFechaCambio());
        assertEquals("test", evento.getRecibidoPor());
    }

    @Test
    public void eventoCambioEstadoDebeExponerSusDatos() {
        LocalDateTime fecha = LocalDateTime.now();

        cl.ucn.solicitudes.application.EventoCambioEstadoSolicitud evento =
                new cl.ucn.solicitudes.application.EventoCambioEstadoSolicitud(
                        8L,
                        EstadoSolicitud.PENDIENTE,
                        EstadoSolicitud.APROBADA,
                        fecha
                );

        assertEquals(8L, evento.getSolicitudId().longValue());
        assertEquals(EstadoSolicitud.PENDIENTE, evento.getEstadoAnterior());
        assertEquals(EstadoSolicitud.APROBADA, evento.getEstadoNuevo());
        assertEquals(fecha, evento.getFechaCambio());
    }
}
