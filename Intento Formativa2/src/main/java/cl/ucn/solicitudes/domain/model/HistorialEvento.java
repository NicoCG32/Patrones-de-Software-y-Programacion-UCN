package cl.ucn.solicitudes.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "historial_eventos")
public class HistorialEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="solicitud_id", nullable = false)
    private Long solicitudId;

    @Enumerated(EnumType.STRING)
    @Column(name="estado_anterior", nullable = false)
    private EstadoSolicitud estadoAnterior;

    @Enumerated(EnumType.STRING)
    @Column(name="estado_nuevo", nullable = false)
    private EstadoSolicitud estadoNuevo;

    @Column(name="fecha_cambio", nullable = false)
    private LocalDateTime fechaCambio;

    @Column(name="recibido_por", nullable = false)
    private String recibidoPor;

    protected HistorialEvento() {
        // Requerido por JPA.
    }

    public HistorialEvento(Long solicitudId,
                           EstadoSolicitud estadoAnterior,
                           EstadoSolicitud estadoNuevo,
                           LocalDateTime fechaCambio,
                           String recibidoPor) {
        this.solicitudId = solicitudId;
        this.estadoAnterior = estadoAnterior;
        this.estadoNuevo = estadoNuevo;
        this.fechaCambio = fechaCambio;
        this.recibidoPor = recibidoPor;
    }

    public Long getId() {
        return id;
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

    public String getRecibidoPor() {
        return recibidoPor;
    }
}
