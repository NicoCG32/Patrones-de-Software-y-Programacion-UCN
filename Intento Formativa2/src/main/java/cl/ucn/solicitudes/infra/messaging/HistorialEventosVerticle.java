package cl.ucn.solicitudes.infra.messaging;

import cl.ucn.solicitudes.domain.model.EstadoSolicitud;
import cl.ucn.solicitudes.domain.model.HistorialEvento;
import cl.ucn.solicitudes.infra.jpa.HistorialEventoRepository;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;

import java.time.LocalDateTime;

/**
 * Receptor de eventos.
 *
 * DEUDA TÉCNICA INTENCIONAL:
 * El verticle conoce directamente un repositorio concreto.
 */
public class HistorialEventosVerticle extends AbstractVerticle {

    private final HistorialEventoRepository historialEventoRepository;

    public HistorialEventosVerticle(HistorialEventoRepository historialEventoRepository) {
        this.historialEventoRepository = historialEventoRepository;
    }

    @Override
    public void start() {
        vertx.eventBus().consumer(VertxPublicadorEventosSolicitud.ADDRESS, message -> {
            JsonObject json = (JsonObject) message.body();

            HistorialEvento evento = new HistorialEvento(
                    json.getLong("solicitudId"),
                    EstadoSolicitud.valueOf(json.getString("estadoAnterior")),
                    EstadoSolicitud.valueOf(json.getString("estadoNuevo")),
                    LocalDateTime.parse(json.getString("fechaCambio")),
                    "HistorialEventosVerticle"
            );

            historialEventoRepository.guardar(evento);
        });
    }
}
