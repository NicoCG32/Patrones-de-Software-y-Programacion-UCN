package cl.ucn.solicitudes.domain.model;

public enum EstadoSolicitud {
    PENDIENTE,
    EN_REVISION,
    APROBADA,
    RECHAZADA;

    public boolean esFinal() {
        return this == APROBADA || this == RECHAZADA;
    }
}
