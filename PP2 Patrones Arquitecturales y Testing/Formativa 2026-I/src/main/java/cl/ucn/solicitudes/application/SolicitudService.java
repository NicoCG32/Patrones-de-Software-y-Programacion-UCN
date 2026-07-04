package cl.ucn.solicitudes.application;

import cl.ucn.solicitudes.domain.model.EstadoSolicitud;
import cl.ucn.solicitudes.domain.model.Estudiante;
import cl.ucn.solicitudes.domain.model.Solicitud;
import cl.ucn.solicitudes.domain.repository.EstudiantePort;
import cl.ucn.solicitudes.domain.repository.SolicitudPort;
import cl.ucn.solicitudes.domain.service.NotificadorExterno;
import cl.ucn.solicitudes.domain.service.PublicadorEventosSolicitud;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Servicio de aplicacion.
 * Coordina casos de uso sin depender de infraestructura concreta.
 */
public class SolicitudService {

    private final EstudiantePort estudiantePort;
    private final SolicitudPort solicitudPort;
    private final PublicadorEventosSolicitud publicadorEventos;
    private final NotificadorExterno notificadorExterno;

    public SolicitudService(EstudiantePort estudiantePort,
                            SolicitudPort solicitudPort,
                            PublicadorEventosSolicitud publicadorEventos,
                            NotificadorExterno notificadorExterno) {
        this.estudiantePort = estudiantePort;
        this.solicitudPort = solicitudPort;
        this.publicadorEventos = publicadorEventos;
        this.notificadorExterno = notificadorExterno;
    }

    public Estudiante registrarEstudiante(String nombre, String correo) {
        Estudiante estudiante = new Estudiante(nombre, correo);
        return estudiantePort.guardar(estudiante);
    }

    public Solicitud crearSolicitud(Long estudianteId, String tipo, String descripcion) {
        Optional<Estudiante> encontrada = estudiantePort.buscarPorId(estudianteId);
        if (encontrada.isEmpty()) {
            throw new IllegalArgumentException("Estudiante inexistente");
        }

        Solicitud solicitud = new Solicitud(encontrada.get(), tipo, descripcion);
        return solicitudPort.guardar(solicitud);
    }

    public Solicitud cambiarEstado(Long solicitudId, EstadoSolicitud nuevoEstado) {
        Optional<Solicitud> encontrada = solicitudPort.buscarPorId(solicitudId);
        if (encontrada.isEmpty()) {
            throw new IllegalArgumentException("No existe la solicitud: " + solicitudId);
        }

        Solicitud solicitud = encontrada.get();
        EstadoSolicitud anterior = solicitud.getEstado();

        solicitud.cambiarEstado(nuevoEstado);
        solicitudPort.guardar(solicitud);

        EventoCambioEstadoSolicitud evento = new EventoCambioEstadoSolicitud(
                solicitud.getId(),
                anterior,
                nuevoEstado,
                LocalDateTime.now()
        );

        publicadorEventos.publicar(evento);

        notificadorExterno.enviarCorreo(
                solicitud.getEstudiante().getCorreo(),
                "Cambio de estado de solicitud",
                "Su solicitud ahora esta en estado: " + nuevoEstado
        );

        return solicitud;
    }
}
