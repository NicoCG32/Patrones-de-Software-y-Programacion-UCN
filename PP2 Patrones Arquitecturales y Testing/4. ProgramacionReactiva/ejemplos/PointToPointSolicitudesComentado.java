package cl.ucn.vertx.estudio;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

/**
 * Ejemplo académico de Point-to-Point con Vert.x.
 *
 * Intención arquitectural:
 * Una solicitud representa una tarea de validación que debe procesar un solo
 * trabajador. Si hay varios trabajadores, Vert.x entrega cada mensaje a uno
 * de ellos, no a todos.
 */
public class PointToPointSolicitudesComentado {

    // Dirección lógica del Event Bus. Es el "canal" de trabajo.
    private static final String ADDRESS = "solicitudes.trabajo.validar";

    public static void main(String[] args) {
        // Crea el runtime de Vert.x.
        Vertx vertx = Vertx.vertx();

        // Despliega dos trabajadores equivalentes.
        vertx.deployVerticle(new ValidadorSolicitudWorker("worker-1"));
        vertx.deployVerticle(new ValidadorSolicitudWorker("worker-2"));

        // Despliega el productor que enviará tareas al Event Bus.
        vertx.deployVerticle(new ProductorSolicitudes());
    }

    /**
     * Verticle productor.
     *
     * Su responsabilidad es generar mensajes de trabajo. No conoce qué worker
     * procesará cada solicitud.
     */
    public static class ProductorSolicitudes extends AbstractVerticle {

        // Contador simple para construir ids distintos en el ejemplo.
        private long contador = 1;

        @Override
        public void start(Promise<Void> startPromise) {
            // Indica a Vert.x que el verticle inició correctamente.
            startPromise.complete();

            // Cada dos segundos se genera una tarea de validación.
            vertx.setPeriodic(2_000, timerId -> {
                // JsonObject es cómodo para enviar datos simples por Event Bus.
                JsonObject solicitud = new JsonObject()
                        .put("solicitudId", contador++)
                        .put("tipo", "Certificado")
                        .put("descripcion", "Validar antecedentes académicos");

                // send implementa point-to-point: un consumidor recibirá esta tarea.
                vertx.eventBus().send(ADDRESS, solicitud);

                // Este mensaje solo ayuda a observar el flujo durante la ejecución.
                System.out.println("Productor envió tarea: " + solicitud.encode());
            });
        }
    }

    /**
     * Verticle consumidor.
     *
     * Cada instancia se registra en la misma dirección. Como el productor usa
     * send, cada tarea llega a una sola instancia.
     */
    public static class ValidadorSolicitudWorker extends AbstractVerticle {

        // Nombre visible del worker para distinguir quién procesó cada tarea.
        private final String nombre;

        public ValidadorSolicitudWorker(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public void start(Promise<Void> startPromise) {
            // Registra el consumidor antes de marcar el verticle como listo.
            vertx.eventBus().<JsonObject>consumer(ADDRESS, message -> {
                // El cuerpo del mensaje contiene la solicitud enviada por el productor.
                JsonObject solicitud = message.body();

                // Aquí iría la regla real de validación. En el ejemplo solo se imprime.
                System.out.println(nombre + " validó solicitud " + solicitud.getLong("solicitudId"));
            });

            // El worker queda disponible para recibir tareas.
            startPromise.complete();
        }
    }
}

