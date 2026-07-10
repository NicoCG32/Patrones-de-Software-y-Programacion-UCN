package cl.ucn.vertx.estudio;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

/**
 * Ejemplo académico de Publish-Subscribe con Vert.x.
 *
 * Intención arquitectural:
 * Un cambio de estado de solicitud es un evento. No se dirige a un receptor
 * único; se publica para que todos los componentes interesados reaccionen.
 *
 * Este es el patrón recomendado para la Formativa PSP.
 */
public class PublishSubscribeSolicitudesComentado {

    // Dirección que representa el evento de dominio/aplicación.
    private static final String ADDRESS = "solicitudes.estado.cambiado";

    public static void main(String[] args) {
        // Runtime de Vert.x.
        Vertx vertx = Vertx.vertx();

        // Cada suscriptor representa una consecuencia independiente del evento.
        vertx.deployVerticle(new HistorialSubscriber());
        vertx.deployVerticle(new AuditoriaSubscriber());
        vertx.deployVerticle(new NotificacionInternaSubscriber());

        // El publicador emite el evento sin conocer a los suscriptores.
        vertx.deployVerticle(new CambioEstadoPublisher());
    }

    /**
     * Publicador del evento.
     *
     * En la Formativa, esta responsabilidad está detrás del puerto
     * PublicadorEventosSolicitud y se implementa con VertxPublicadorEventosSolicitud.
     */
    public static class CambioEstadoPublisher extends AbstractVerticle {

        @Override
        public void start(Promise<Void> startPromise) {
            startPromise.complete();

            // Se usa setTimer para publicar una vez y observar el comportamiento.
            vertx.setTimer(1_000, timerId -> {
                // El payload debe contener datos suficientes para que los receptores actúen.
                JsonObject evento = new JsonObject()
                        .put("solicitudId", 15L)
                        .put("estadoAnterior", "PENDIENTE")
                        .put("estadoNuevo", "EN_REVISION")
                        .put("fechaCambio", "2026-06-22T10:00:00");

                // publish entrega una copia del evento a todos los consumidores suscritos.
                vertx.eventBus().publish(ADDRESS, evento);

                // El publicador no sabe cuántos suscriptores existen.
                System.out.println("Publicado evento: " + evento.encode());
            });
        }
    }

    /**
     * Suscriptor de historial.
     *
     * Responsabilidad: dejar evidencia persistente de lo ocurrido.
     */
    public static class HistorialSubscriber extends AbstractVerticle {

        @Override
        public void start(Promise<Void> startPromise) {
            vertx.eventBus().<JsonObject>consumer(ADDRESS, message -> {
                JsonObject evento = message.body();

                // En un sistema real, aquí se guardaría un HistorialEvento.
                System.out.println("Historial registró solicitud " + evento.getLong("solicitudId"));
            });

            startPromise.complete();
        }
    }

    /**
     * Suscriptor de auditoría.
     *
     * Responsabilidad: registrar trazabilidad técnica o administrativa.
     */
    public static class AuditoriaSubscriber extends AbstractVerticle {

        @Override
        public void start(Promise<Void> startPromise) {
            vertx.eventBus().<JsonObject>consumer(ADDRESS, message -> {
                JsonObject evento = message.body();

                // La auditoría puede guardar quién cambió el estado, cuándo y desde dónde.
                System.out.println("Auditoría observó nuevo estado " + evento.getString("estadoNuevo"));
            });

            startPromise.complete();
        }
    }

    /**
     * Suscriptor de notificación interna.
     *
     * Responsabilidad: informar a otros módulos sin acoplarlos al caso de uso.
     */
    public static class NotificacionInternaSubscriber extends AbstractVerticle {

        @Override
        public void start(Promise<Void> startPromise) {
            vertx.eventBus().<JsonObject>consumer(ADDRESS, message -> {
                JsonObject evento = message.body();

                // Podría actualizar una pantalla, enviar una alerta o alimentar métricas.
                System.out.println("Notificación interna recibió evento de solicitud "
                        + evento.getLong("solicitudId"));
            });

            startPromise.complete();
        }
    }
}

