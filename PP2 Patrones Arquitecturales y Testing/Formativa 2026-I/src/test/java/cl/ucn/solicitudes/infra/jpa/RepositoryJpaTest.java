package cl.ucn.solicitudes.infra.jpa;

import cl.ucn.solicitudes.domain.model.EstadoSolicitud;
import cl.ucn.solicitudes.domain.model.Estudiante;
import cl.ucn.solicitudes.domain.model.HistorialEvento;
import cl.ucn.solicitudes.domain.model.Solicitud;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RepositoryJpaTest {

    @Test
    public void repositoriosDebenGuardarYBuscarEntidades() {
        EstudianteRepository estudiantes = new EstudianteRepository();
        SolicitudRepository solicitudes = new SolicitudRepository();
        HistorialEventoRepository historial = new HistorialEventoRepository();

        String correo = "ana+" + System.nanoTime() + "@universidad.cl";
        Estudiante estudiante = estudiantes.guardar(new Estudiante("Ana Torres", correo));

        assertNotNull(estudiante.getId());
        assertTrue(estudiantes.buscarPorId(estudiante.getId()).isPresent());
        assertFalse(estudiantes.buscarTodos().isEmpty());

        Solicitud solicitud = new Solicitud(
                estudiante,
                "Certificado",
                "Solicita certificado de alumno regular"
        );
        solicitud = solicitudes.guardar(solicitud);

        assertNotNull(solicitud.getId());
        assertTrue(solicitudes.buscarPorId(solicitud.getId()).isPresent());
        assertFalse(solicitudes.buscarPorEstado(EstadoSolicitud.PENDIENTE).isEmpty());
        assertFalse(solicitudes.buscarTodas().isEmpty());

        solicitud.cambiarEstado(EstadoSolicitud.EN_REVISION);
        solicitudes.guardar(solicitud);
        assertFalse(solicitudes.buscarPorEstado(EstadoSolicitud.EN_REVISION).isEmpty());

        HistorialEvento evento = historial.guardar(new HistorialEvento(
                solicitud.getId(),
                EstadoSolicitud.PENDIENTE,
                EstadoSolicitud.EN_REVISION,
                LocalDateTime.now(),
                "RepositoryJpaTest"
        ));

        assertNotNull(evento.getId());
        assertFalse(historial.buscarTodos().isEmpty());
    }
}
