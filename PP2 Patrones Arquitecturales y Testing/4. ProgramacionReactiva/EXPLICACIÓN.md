# Explicación Detallada - Programación Reactiva y Mensajería con Vert.x

## Para qué sirve

La programación reactiva organiza componentes que responden a eventos y resultados asíncronos sin bloquear hilos mientras esperan. Busca mantener capacidad de respuesta y uso eficiente de recursos ante muchas operaciones concurrentes, especialmente de entrada y salida.

El material usa el Event Bus de Vert.x para estudiar tres semánticas:

- **Point-to-point**: un consumidor procesa la tarea.
- **Publish-subscribe**: todos los suscriptores reciben el evento.
- **Request-response**: un consumidor procesa y responde de forma asíncrona.

Programación reactiva, programación dirigida por eventos y mensajería no son sinónimos absolutos. Vert.x combina estos conceptos, pero cada uno describe una dimensión diferente.

## Cómo se usa

Un verticle registra handlers y retorna el control al event loop. Cuando ocurre un evento, Vert.x invoca el handler.

```text
registrar handler -> liberar hilo -> llega evento -> ejecutar callback
```

La regla operacional principal es no bloquear el event loop. JDBC tradicional, archivos pesados o cálculos largos deben ejecutarse mediante worker verticles, mecanismos de trabajo bloqueante o clientes no bloqueantes.

Para seleccionar la semántica:

1. Use `send` cuando una tarea debe asignarse a un consumidor.
2. Use `publish` cuando comunica un hecho a múltiples interesados.
3. Use `request` cuando necesita una respuesta y una política de timeout.

Los mensajes deben ser pequeños, explícitos y versionables. Los handlers deben considerar errores, duplicados e idempotencia según la criticidad.

## Por qué se usa

El modelo evita dedicar un hilo bloqueado a cada espera y desacopla emisores de receptores mediante direcciones. Esto permite construir componentes concurrentes con comunicación explícita.

No elimina la complejidad. La traslada hacia callbacks o futuros, orden, cancelación, presión de retorno, fallos y observabilidad.

## Contextos de aplicación

Es apropiada para gateways, servidores de red, procesamiento de eventos, notificaciones y sistemas con muchas operaciones de I/O concurrentes. Publish-subscribe resulta útil para eventos de dominio; point-to-point para trabajo distribuido; request-response para consultas internas.

No conviene introducirla en procesamiento secuencial pequeño sin necesidad de concurrencia. Tampoco debe usarse un bus no durable como sustituto automático de una cola persistente.

## Ventajas

- Buen aprovechamiento de hilos en cargas de I/O.
- Componentes desacoplados por mensajes.
- Composición de tareas asíncronas.
- Soporte local y distribuido en Vert.x.
- Varias semánticas de comunicación.

## Desventajas

- Flujo y errores menos lineales.
- Bloqueos accidentales degradan todo el event loop.
- Entrega best-effort puede perder mensajes ante fallos.
- Depuración y trazas requieren contexto propagado.
- Estado compartido y orden exigen disciplina.
- Sin presión de retorno puede acumularse trabajo.

## Origen y evolución

La programación dirigida por eventos tiene antecedentes en interfaces, sistemas de telecomunicaciones y actores. La programación reactiva moderna se consolidó con flujos asíncronos, el Reactive Manifesto y la iniciativa Reactive Streams, que normalizó presión de retorno para secuencias asíncronas.

Vert.x nació como toolkit event-driven para la JVM y evolucionó desde callbacks hacia `Future`, composición y APIs modernas, manteniendo verticles y Event Bus. El ecosistema incorporó clientes reactivos, clustering, trazas y puentes con otros protocolos.

## Estado actual

El enfoque reactivo sigue vigente para cargas concurrentes y streaming, pero ya no se considera una solución universal. Hilos virtuales ofrecen otra forma de expresar concurrencia bloqueante con código secuencial. La elección debe comparar carga, bibliotecas, observabilidad y experiencia del equipo.

El Event Bus continúa siendo útil dentro de Vert.x, pero su entrega es best-effort. Cuando se requiere durabilidad, relectura o garantías fuertes, debe integrarse un broker o almacenamiento adecuado.

## Criterios de diseño

- No bloquear el event loop.
- Definir timeout y fallos en request-response.
- Hacer idempotentes los consumidores críticos.
- No compartir estado mutable sin control.
- Distinguir comando, evento y consulta.
- Medir colas, latencia y errores.

## Material de esta carpeta

El [README](README.md) desarrolla cada semántica y enlaza tres ejemplos comentados en `ejemplos/`.

## Referencias

- [Vert.x Core Manual: Event Bus](https://vertx.io/docs/vertx-core/java/).
- [API oficial de EventBus](https://vertx.io/docs/apidocs/io/vertx/core/eventbus/EventBus.html).
- [Reactive Streams](https://www.reactive-streams.org/).
