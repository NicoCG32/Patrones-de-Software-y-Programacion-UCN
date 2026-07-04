package cl.ucn.solicitudes.infra.messaging;

import cl.ucn.solicitudes.domain.model.EstadoSolicitud;
import cl.ucn.solicitudes.domain.model.HistorialEvento;
import cl.ucn.solicitudes.domain.repository.HistorialEventoPort;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.JsonObject;

import java.time.LocalDateTime;

/**
 * Receptor de eventos.
 * Guarda una evidencia cada vez que recibe un cambio de estado.
 */
public class HistorialEventosVerticle extends AbstractVerticle {

    private final HistorialEventoPort historialEventoPort;

    public HistorialEventosVerticle(HistorialEventoPort historialEventoPort) {
        this.historialEventoPort = historialEventoPort;
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

            historialEventoPort.guardar(evento);
        });
    }
}
