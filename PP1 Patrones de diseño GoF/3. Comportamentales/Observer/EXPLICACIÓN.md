# Explicación Detallada - Observer

## Para qué sirve

Observer define una relación uno-a-muchos: cuando un sujeto cambia o emite un evento, notifica a los observadores registrados. Permite que productores y consumidores colaboren sin que el productor conozca las acciones concretas de cada consumidor.

El patrón resuelve propagación de cambios y extensibilidad de reacciones. No garantiza por sí solo asincronía, persistencia ni entrega distribuida.

## Cómo se usa

Participan:

- **Subject**: registra, elimina y notifica observadores.
- **Observer**: contrato de recepción.
- **ConcreteObserver**: ejecuta una reacción.
- **Evento o estado**: información enviada o consultada tras la notificación.

Existen dos modelos:

- **Push**: el sujeto incluye los datos relevantes en el evento.
- **Pull**: el observador recibe una señal y consulta al sujeto.

El modelo push reduce consultas y hace explícito el evento; el modelo pull puede evitar eventos demasiado grandes, pero acopla al observador con el sujeto.

Debe definirse quién se suscribe, cuándo se elimina la suscripción, qué ocurre ante excepciones y si el orden importa. Las referencias persistentes a observadores que ya no se usan pueden causar fugas de memoria.

## Por qué se usa

Separa el cambio principal de sus consecuencias secundarias. Nuevos observadores pueden añadirse sin modificar al sujeto, lo que favorece extensibilidad.

## Contextos de aplicación

Es frecuente en GUI, eventos de dominio, notificaciones, tableros, cachés derivadas y sistemas de plugins. En una misma memoria puede implementarse con listas de funciones; entre procesos requiere mensajería y garantías adicionales.

No conviene cuando el flujo debe ser estrictamente secuencial y explícito, cuando existen ciclos de notificación o cuando una reacción es parte indispensable de la transacción principal.

## Ventajas y desventajas

### Ventajas

- Reduce conocimiento entre emisor y receptores.
- Permite múltiples reacciones extensibles.
- Modela eventos de forma explícita.
- Facilita conectar y retirar comportamiento en ejecución.

### Desventajas

- El flujo de control se vuelve menos visible.
- El orden de observadores puede producir acoplamiento implícito.
- Excepciones y reentradas requieren una política.
- Las suscripciones mal administradas generan fugas.
- En sistemas distribuidos aparecen duplicados, pérdidas y consistencia eventual.

## Origen y evolución

Observer fue sistematizado por GoF en 1994 y tiene antecedentes en sistemas interactivos y el enfoque Modelo-Vista-Controlador de Smalltalk. La necesidad original era mantener varias representaciones sincronizadas con un modelo.

Evolucionó hacia listeners, event emitters, buses de eventos y flujos reactivos. Estas tecnologías amplían el patrón con asincronía, composición, presión de retorno o transporte, pero no deben confundirse automáticamente con el Observer de objetos.

## Estado actual

Observer sigue siendo central en interfaces y arquitecturas dirigidas por eventos. La práctica moderna favorece eventos inmutables, suscripciones cancelables y contratos claros. Para integración distribuida se requieren identificadores, idempotencia, persistencia y observabilidad.

## Patrones relacionados

- **Mediator** centraliza coordinación entre varios objetos.
- **Publish-Subscribe** puede desacoplar también la identidad y ubicación mediante un broker.
- **Reactive Streams** agrega un protocolo de demanda y presión de retorno.
- **MVC** utiliza observación para actualizar vistas en algunas variantes.

## Material de esta carpeta

El [README](README.md) y los ejemplos de eventos de dominio y tablero muestran notificación uno-a-muchos. Debe revisarse el ciclo completo de suscripción, emisión y liberación.

## Referencia principal

Gamma, E., Helm, R., Johnson, R. y Vlissides, J. (1994). *Design Patterns: Elements of Reusable Object-Oriented Software*. Addison-Wesley.
