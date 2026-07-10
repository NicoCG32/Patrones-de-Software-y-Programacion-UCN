package cl.ucn.vertx.estudio;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

/**
 * Ejemplo académico de Request-Response con Vert.x.
 *
 * Intención arquitectural:
 * Un cliente necesita consultar el estado de una solicitud y espera una
 * respuesta. La comunicación sigue siendo asíncrona: el cliente registra un
 * callback y Vert.x lo ejecuta cuando llegue la respuesta.
 */
public class RequestResponseSolicitudesComentado {

    // Dirección del servicio de consulta.
    private static final String ADDRESS = "solicitudes.consulta.estado";

    public static void main(String[] args) {
        // Runtime de Vert.x.
        Vertx vertx = Vertx.vertx();

        // Primero se despliega el servicio que responderá consultas.
        vertx.deployVerticle(new ServicioConsultaSolicitud(), despliegue -> {
            if (despliegue.succeeded()) {
                // Luego se despliega el cliente para evitar pedir antes de que exista receptor.
                vertx.deployVerticle(new ClienteConsultaSolicitud());
            } else {
                // Si el servicio no inicia, no tiene sentido desplegar el cliente.
                System.err.println("No se pudo desplegar el servicio: " + despliegue.cause());
            }
        });
    }

    /**
     * Cliente que realiza una consulta.
     *
     * En una aplicación real podría ser un controlador, una API o un módulo de
     * interfaz que necesita conocer el estado actual.
     */
    public static class ClienteConsultaSolicitud extends AbstractVerticle {

        @Override
        public void start(Promise<Void> startPromise) {
            startPromise.complete();

            // Payload de consulta: se pregunta por una solicitud específica.
            JsonObject consulta = new JsonObject()
                    .put("solicitudId", 15L);

            // request envía el mensaje y registra un callback para la respuesta.
            vertx.eventBus().<JsonObject>request(ADDRESS, consulta, respuesta -> {
                // Siempre se revisa si la operación asíncrona tuvo éxito.
                if (respuesta.succeeded()) {
                    // Si hubo respuesta, se obtiene el cuerpo respondido por el servicio.
                    JsonObject cuerpo = respuesta.result().body();
                    System.out.println("Estado recibido: " + cuerpo.encode());
                } else {
                    // Si no hubo respuesta, se maneja el error sin bloquear el hilo.
                    System.err.println("Consulta fallida: " + respuesta.cause().getMessage());
                }
            });
        }
    }

    /**
     * Servicio que responde consultas.
     *
     * Su responsabilidad es recibir una pregunta y contestar explícitamente con
     * message.reply(...).
     */
    public static class ServicioConsultaSolicitud extends AbstractVerticle {

        @Override
        public void start(Promise<Void> startPromise) {
            // Se registra el consumidor que atenderá solicitudes de consulta.
            vertx.eventBus().<JsonObject>consumer(ADDRESS, message -> {
                // Se extraen datos del request.
                JsonObject consulta = message.body();
                Long solicitudId = consulta.getLong("solicitudId");

                // En un sistema real, aquí se consultaría un puerto o repositorio.
                JsonObject respuesta = new JsonObject()
                        .put("solicitudId", solicitudId)
                        .put("estadoActual", "EN_REVISION")
                        .put("encontrada", true);

                // reply completa el patrón request-response.
                message.reply(respuesta);
            });

            // El servicio queda disponible para responder.
            startPromise.complete();
        }
    }
}

