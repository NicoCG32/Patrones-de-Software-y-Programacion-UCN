package cl.ucn.solicitudes.infra.messaging;

import cl.ucn.solicitudes.application.EventoCambioEstadoSolicitud;
import cl.ucn.solicitudes.domain.service.PublicadorEventosSolicitud;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

public class VertxPublicadorEventosSolicitud extends AbstractVerticle implements PublicadorEventosSolicitud {

    public static final String ADDRESS = "solicitudes.estado.cambiado";

    private final Vertx vertx;

    public VertxPublicadorEventosSolicitud(Vertx vertx) {
        this.vertx = vertx;
    }

    @Override
    public void publicar(EventoCambioEstadoSolicitud evento) {
        JsonObject payload = new JsonObject()
                .put("solicitudId", evento.getSolicitudId())
                .put("estadoAnterior", evento.getEstadoAnterior().name())
                .put("estadoNuevo", evento.getEstadoNuevo().name())
                .put("fechaCambio", evento.getFechaCambio().toString());

        vertx.eventBus().publish(ADDRESS, payload);
    }
}
