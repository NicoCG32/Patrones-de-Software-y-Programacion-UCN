package cl.ucn.solicitudes.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolicitudDomainTest {

    @Test
    public void solicitudNuevaDebeQuedarPendiente() {
        Estudiante estudiante = new Estudiante("Ana Torres", "ana@universidad.cl");

        Solicitud solicitud = new Solicitud(
                estudiante,
                "Certificado",
                "Solicita certificado de alumno regular"
        );

        assertEquals(EstadoSolicitud.PENDIENTE, solicitud.getEstado());
    }

    @Test(expected = IllegalArgumentException.class)
    public void solicitudNoDebeAceptarDescripcionVacia() {
        Estudiante estudiante = new Estudiante("Ana Torres", "ana@universidad.cl");

        new Solicitud(estudiante, "Certificado", " ");
    }

    @Test(expected = IllegalStateException.class)
    public void solicitudFinalizadaNoDebeCambiarEstado() {
        Estudiante estudiante = new Estudiante("Ana Torres", "ana@universidad.cl");
        Solicitud solicitud = new Solicitud(estudiante, "Certificado", "Solicitud válida");

        solicitud.cambiarEstado(EstadoSolicitud.APROBADA);
        solicitud.cambiarEstado(EstadoSolicitud.EN_REVISION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void RechazoDeSolicitudConEstudianteNulo(){
        Estudiante e = null;
        Solicitud s = new Solicitud(e, "tipo", "descripcion");
    }

    @Test(expected = IllegalArgumentException.class)
    public void RechazoDeSolicitudConTipoVacio(){
        Estudiante e = new Estudiante("Ana Torres", "ana@universidad.cl");;
        Solicitud s = new Solicitud(e, "", "descripcion");
    }

    @Test(expected = IllegalArgumentException.class)
    public void RechazoDeSolicitudConDescripcionVacia(){
        Estudiante e = new Estudiante("Ana Torres", "ana@universidad.cl");;
        Solicitud s = new Solicitud(e, "tipo", "");
    }
}
