package cl.ucn.solicitudes.application;

import cl.ucn.solicitudes.domain.model.EstadoSolicitud;
import cl.ucn.solicitudes.domain.model.Solicitud;
import cl.ucn.solicitudes.domain.repository.SolicitudPort;
import cl.ucn.solicitudes.domain.service.NotificadorExterno;
import cl.ucn.solicitudes.domain.service.PublicadorEventosSolicitud;
import cl.ucn.solicitudes.infra.jpa.SolicitudRepository;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Servicio de aplicación parcialmente correcto.
 *
 * DEUDA TÉCNICA INTENCIONAL:
 * Esta clase aún depende de un repositorio concreto de infraestructura.
 * El estudiante debe desacoplarla mediante un puerto o interfaz.
 */
public class SolicitudService {

    private final SolicitudPort solicitudPort;
    private final PublicadorEventosSolicitud publicadorEventos;
    private final NotificadorExterno notificadorExterno;

    public SolicitudService(PublicadorEventosSolicitud publicadorEventos,
                            NotificadorExterno notificadorExterno,
                            SolicitudPort solicitudPort) {
        this.publicadorEventos = publicadorEventos;
        this.notificadorExterno = notificadorExterno;
        this.solicitudPort = solicitudPort;
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
                "Su solicitud ahora está en estado: " + nuevoEstado
        );

        return solicitud;
    }

    public Solicitud guardar(Solicitud solicitud) {
        return solicitudPort.guardar(solicitud);
    }

    public Optional<Solicitud> buscarPorId(Long solicitudId) {
        return solicitudPort.buscarPorId(solicitudId);
    }

    public void enviarCorreo(String correo, String cambioDeEstado, String s) {
        notificadorExterno.enviarCorreo(correo, cambioDeEstado, s);
    }
}
