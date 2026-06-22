# Programación Reactiva con Vert.x y Event Bus

## 1. Punto de partida

El repositorio de referencia `IS-LAB-EIC-UCN/VertX` presenta tres patrones de comunicación con Vert.x:

```text
1. Point-to-Point
2. Publish-Subscribe
3. Request-Response
```

Los tres usan el mismo mecanismo base: el **Event Bus** de Vert.x. Lo que cambia es la semántica de entrega del mensaje.

Vert.x no obliga a construir una aplicación completa con una sola arquitectura. En un sistema real puedes combinar los tres patrones:

- `send(...)` para asignar una tarea a un solo trabajador;
- `publish(...)` para difundir un evento a muchos interesados;
- `request(...)` para pedir una respuesta explícita a otro componente.

## 2. Conceptos mínimos de Vert.x

### 2.1. Verticle

Un verticle es una unidad desplegable de Vert.x. Normalmente extiende `AbstractVerticle`.

```java
public class MiVerticle extends AbstractVerticle {
    @Override
    public void start() {
        // Aquí se registra la lógica que ejecutará el verticle.
    }
}
```

En términos arquitecturales, un verticle suele representar un componente autónomo:

- publicador de eventos;
- receptor de historial;
- servicio de consulta;
- trabajador de procesamiento;
- adaptador hacia una tecnología externa.

### 2.2. Vertx

`Vertx.vertx()` crea el runtime:

```java
Vertx vertx = Vertx.vertx();
```

Con esa instancia se despliegan verticles:

```java
vertx.deployVerticle(new MiVerticle());
```

### 2.3. Event Bus

El Event Bus es un canal de comunicación interno. Los componentes no se llaman directamente entre sí; envían mensajes a una **dirección** textual.

```java
vertx.eventBus().consumer("direccion", message -> {
    System.out.println(message.body());
});
```

```java
vertx.eventBus().send("direccion", "mensaje");
```

Idea clave:

```text
El emisor conoce una dirección, no necesariamente una clase receptora concreta.
```

Eso reduce acoplamiento.

## 3. Comparación rápida de las tres arquitecturas

| Patrón | Método Vert.x | Reciben el mensaje | ¿Hay respuesta? | Necesidad típica |
| --- | --- | --- | --- | --- |
| Point-to-Point | `send` | Un consumidor | No necesariamente | Repartir tareas entre trabajadores |
| Publish-Subscribe | `publish` | Todos los consumidores suscritos | No | Difundir eventos de dominio |
| Request-Response | `request` | Un consumidor que responde | Sí | Consultar o pedir cálculo a otro componente |

## 4. Arquitectura 1: Point-to-Point

### 4.1. Idea

En Point-to-Point, el emisor manda un mensaje a una dirección y **solo un consumidor** lo procesa.

Sintaxis esencial:

```java
vertx.eventBus().send("solicitudes.trabajo.validar", payload);
```

Consumidor:

```java
vertx.eventBus().consumer("solicitudes.trabajo.validar", message -> {
    Object cuerpo = message.body();
});
```

### 4.2. Contexto adecuado

Este patrón sirve cuando el mensaje representa una **tarea que debe ejecutarse una sola vez**.

Ejemplos:

- validar una solicitud académica;
- generar un archivo;
- enviar un correo concreto;
- procesar una inscripción;
- repartir carga entre varios trabajadores equivalentes.

### 4.3. Necesidad que resuelve

Resuelve la necesidad de distribuir trabajo:

```text
Productor -> Event Bus -> un Worker disponible
```

Si hay varios consumidores registrados en la misma dirección, el emisor no decide manualmente cuál trabaja. Esa decisión queda desacoplada.

### 4.4. Cuándo no conviene

No conviene si todos los interesados deben enterarse del mensaje. Por ejemplo, si una solicitud cambió de estado y quieres que historial, auditoría y notificación interna reaccionen, `send` no es el patrón más natural, porque solo uno recibiría el mensaje.

### 4.5. Implementación paso a paso

1. Define una dirección estable.
2. Crea uno o más consumidores.
3. Cada consumidor se registra con `consumer(address, handler)`.
4. El productor usa `send(address, payload)`.
5. Solo un consumidor procesa cada mensaje.

Archivo de estudio:

```text
ProgramacionReactiva/ejemplos/PointToPointSolicitudesComentado.java
```

## 5. Arquitectura 2: Publish-Subscribe

### 5.1. Idea

En Publish-Subscribe, el publicador envía un mensaje a una dirección y **todos los consumidores suscritos** reciben una copia.

Sintaxis esencial:

```java
vertx.eventBus().publish("solicitudes.estado.cambiado", payload);
```

Consumidores:

```java
vertx.eventBus().consumer("solicitudes.estado.cambiado", message -> {
    Object cuerpo = message.body();
});
```

### 5.2. Contexto adecuado

Este patrón sirve cuando el mensaje representa un **evento**: algo que ya ocurrió y puede interesar a múltiples componentes.

Ejemplos:

- solicitud cambió de estado;
- estudiante fue registrado;
- pago fue confirmado;
- stock fue actualizado;
- sesión fue cerrada.

### 5.3. Necesidad que resuelve

Resuelve la necesidad de desacoplar un hecho de sus consecuencias:

```text
SolicitudService
      |
      | publica "solicitud cambió de estado"
      v
Event Bus
      |-----------------> Historial
      |-----------------> Auditoría
      |-----------------> Notificación
```

El caso de uso principal no necesita saber cuántos receptores existen.

### 5.4. Relación directa con la Formativa PSP

La Formativa recomienda publish-subscribe para el cambio de estado de una solicitud.

Ese evento no es una orden dirigida a un único receptor. Es un hecho del sistema:

```text
La solicitud 15 pasó de PENDIENTE a EN_REVISION.
```

Ese hecho puede ser útil para:

- guardar historial;
- auditar acciones;
- actualizar métricas;
- notificar a otros módulos;
- alimentar una pantalla de monitoreo.

Por eso `publish(...)` es más adecuado que `send(...)`.

### 5.5. Cuándo no conviene

No conviene si necesitas una respuesta inmediata del receptor. Tampoco conviene si el mensaje debe ser procesado por exactamente un trabajador. En esos casos, usa `request(...)` o `send(...)`.

### 5.6. Implementación paso a paso

1. Define una dirección de evento, por ejemplo `solicitudes.estado.cambiado`.
2. Modela el payload con datos suficientes: id, estado anterior, estado nuevo, fecha.
3. Registra consumidores independientes.
4. Publica el evento con `publish`.
5. Cada consumidor decide qué hacer con su copia.

Archivo de estudio:

```text
ProgramacionReactiva/ejemplos/PublishSubscribeSolicitudesComentado.java
```

## 6. Arquitectura 3: Request-Response

### 6.1. Idea

En Request-Response, un componente envía una solicitud y espera una respuesta asíncrona.

Sintaxis esencial:

```java
vertx.eventBus().request("solicitudes.consulta.estado", payload, respuesta -> {
    if (respuesta.succeeded()) {
        Object cuerpo = respuesta.result().body();
    }
});
```

Responder:

```java
vertx.eventBus().consumer("solicitudes.consulta.estado", message -> {
    message.reply("respuesta");
});
```

### 6.2. Contexto adecuado

Este patrón sirve cuando un componente necesita **un dato de vuelta**.

Ejemplos:

- consultar el estado actual de una solicitud;
- pedir una validación remota;
- obtener la disponibilidad de cupos;
- calcular un resultado en otro componente;
- preguntar si una operación puede continuar.

### 6.3. Necesidad que resuelve

Resuelve una comunicación parecida a una llamada de método, pero asíncrona:

```text
Cliente -> Event Bus -> Servicio
Cliente <- Event Bus <- Respuesta
```

El cliente no bloquea el hilo esperando como en una llamada tradicional. Registra un callback que se ejecutará cuando llegue la respuesta.

### 6.4. Cuándo no conviene

No conviene si el emisor no necesita respuesta. Para eventos de dominio, publish-subscribe suele ser más limpio. Para tareas de fondo sin respuesta, point-to-point suele ser suficiente.

### 6.5. Implementación paso a paso

1. Define una dirección de consulta.
2. Crea un verticle proveedor que consuma esa dirección.
3. El proveedor procesa el mensaje y llama `message.reply(...)`.
4. El cliente usa `request(...)`.
5. El cliente revisa `reply.succeeded()` antes de leer el cuerpo.

Archivo de estudio:

```text
ProgramacionReactiva/ejemplos/RequestResponseSolicitudesComentado.java
```

## 7. Regla de diseño para el examen

Para decidir qué patrón usar, identifica la intención del mensaje:

```text
¿Es una tarea para un solo trabajador?
    -> Point-to-Point con send.

¿Es un evento que varios componentes podrían observar?
    -> Publish-Subscribe con publish.

¿Es una consulta o petición que necesita respuesta?
    -> Request-Response con request y reply.
```

Aplicado a la Formativa:

```text
Cambiar estado de solicitud
    -> caso de uso síncrono en SolicitudService.

Después del cambio correcto
    -> evento "estado cambiado".

Como puede interesar a historial, auditoría y notificaciones
    -> publish-subscribe.
```

## 8. Advertencias técnicas importantes

### 8.1. No bloquear el event loop

Vert.x está diseñado para operaciones no bloqueantes. Acciones como JPA, JDBC tradicional, lectura pesada de archivos o llamadas externas bloqueantes deben tratarse con cuidado.

En una formativa pequeña, un verticle puede guardar historial directamente para simplificar. En un sistema productivo, lo más riguroso sería usar:

- worker verticles;
- `executeBlocking`;
- clientes reactivos;
- colas externas persistentes si se requiere durabilidad fuerte.

### 8.2. El Event Bus no es una base de datos

El Event Bus comunica mensajes. No reemplaza persistencia. Si necesitas auditoría verificable, debes guardar evidencia en un repositorio, como hace `HistorialEventosVerticle` en la Formativa.

### 8.3. Entrega best-effort

El Event Bus de Vert.x es liviano y desacoplado. Para mensajería crítica con reintentos, confirmaciones durables o persistencia de eventos, se evalúan mecanismos adicionales.

## 9. Equivalencia con el repositorio VertX citado

| Repositorio `IS-LAB-EIC-UCN/VertX` | Método clave | Ejemplo adaptado aquí |
| --- | --- | --- |
| `cl.ucn.pointtopoint.PointToPoint` | `eventBus().send(...)` | `PointToPointSolicitudesComentado.java` |
| `cl.ucn.publishsubscribe.PublishSubscribe` | `eventBus().publish(...)` | `PublishSubscribeSolicitudesComentado.java` |
| `cl.ucn.requestresponse.RequestResponse` | `eventBus().request(...)` y `message.reply(...)` | `RequestResponseSolicitudesComentado.java` |

## 10. Fuentes primarias consultadas

- Repositorio VertX UCN: https://github.com/IS-LAB-EIC-UCN/VertX
- Vert.x EventBus API: https://vertx.io/docs/apidocs/io/vertx/core/eventbus/EventBus.html
- Formativa PSP local: `Formativa 2026-I/src/main/java/cl/ucn/solicitudes/infra/messaging`.

