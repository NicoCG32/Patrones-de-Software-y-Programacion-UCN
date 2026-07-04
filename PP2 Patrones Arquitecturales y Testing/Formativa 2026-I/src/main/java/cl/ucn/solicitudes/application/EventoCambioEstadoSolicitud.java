package cl.ucn.solicitudes.application;

import cl.ucn.solicitudes.domain.model.EstadoSolicitud;

import java.time.LocalDateTime;

public class EventoCambioEstadoSolicitud {

    private final Long solicitudId;
    private final EstadoSolicitud estadoAnterior;
    private final EstadoSolicitud estadoNuevo;
    private final LocalDateTime fechaCambio;

    public EventoCambioEstadoSolicitud(Long solicitudId,
                                       EstadoSolicitud estadoAnterior,
                                       EstadoSolicitud estadoNuevo,
                                       LocalDateTime fechaCambio) {
        this.solicitudId = solicitudId;
        this.estadoAnterior = estadoAnterior;
        this.estadoNuevo = estadoNuevo;
        this.fechaCambio = fechaCambio;
    }

    public Long getSolicitudId() {
        return solicitudId;
    }

    public EstadoSolicitud getEstadoAnterior() {
        return estadoAnterior;
    }

    public EstadoSolicitud getEstadoNuevo() {
        return estadoNuevo;
    }

    public LocalDateTime getFechaCambio() {
        return fechaCambio;
    }
}
