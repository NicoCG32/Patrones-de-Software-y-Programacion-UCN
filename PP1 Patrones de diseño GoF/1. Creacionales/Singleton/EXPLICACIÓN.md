# Explicación Detallada - Singleton

## Para qué sirve

Singleton garantiza que una clase controle una única instancia dentro de un ámbito definido y proporciona un punto de acceso a ella. La frase “una única instancia” debe interpretarse con precisión: suele significar una por cargador de clases o proceso, no una instancia universal en todas las máquinas.

El patrón se usa cuando la unicidad es una **invariante real** del recurso, no solo porque resulte cómodo acceder globalmente a un objeto.

## Cómo se usa

La forma clásica contiene:

- Constructor no público.
- Campo estático que conserva la instancia.
- Operación estática que devuelve esa instancia.

En Java, un `enum` con un único elemento ofrece inicialización segura y soporte de serialización. Si se usa inicialización diferida con múltiples hilos, deben respetarse las reglas del modelo de memoria; una implementación ingenua puede crear más de una instancia o publicar un objeto incompleto.

Antes de implementarlo se debe responder:

1. Qué recurso exige unicidad.
2. Cuál es el ámbito de esa unicidad.
3. Quién controla su ciclo de vida.
4. Cómo se sustituirá en pruebas.
5. Qué ocurre en ejecución concurrente o distribuida.

## Por qué se usa

Centraliza la creación y evita instancias contradictorias de un coordinador, registro o configuración. Sin embargo, el acceso global no es gratuito: oculta dependencias y puede introducir estado compartido.

## Contextos de aplicación

Puede ser razonable para registros de infraestructura, coordinadores estrictamente únicos dentro de una JVM o adaptadores sobre recursos únicos. Muchos casos tradicionales, como logging o configuración, se resuelven mejor mediante inyección de una instancia administrada por el contenedor.

No garantiza exclusión distribuida, unicidad en una base de datos ni una instancia por clúster. Esos problemas requieren mecanismos externos.

## Ventajas y desventajas

### Ventajas

- Controla explícitamente la creación.
- Puede diferir la inicialización.
- Ofrece acceso uniforme a un recurso único.
- Evita duplicación cuando la unicidad pertenece al dominio técnico.

### Desventajas

- Actúa como estado global y oculta dependencias.
- Dificulta el aislamiento y paralelismo de pruebas.
- Acopla consumidores a un mecanismo de acceso.
- Exige cuidado con hilos, serialización, reflexión y cargadores de clases.
- Suele acumular responsabilidades ajenas.

## Origen y evolución

Singleton fue formalizado por GoF en 1994. En aplicaciones de escritorio y frameworks de una sola máquina ofrecía una forma directa de controlar servicios únicos.

Con la expansión de pruebas automatizadas, contenedores de inversión de control y sistemas distribuidos, su uso se volvió más crítico. Los contenedores permiten un **alcance singleton** sin obligar a la clase a administrar su propia instancia. Así, la unicidad se transforma en política de composición y las clases consumidoras reciben dependencias explícitas.

## Estado actual

Singleton sigue siendo válido en casos delimitados, pero se considera una decisión de alto costo cuando combina acceso global y estado mutable. La práctica actual favorece inyección de dependencias, objetos inmutables y ámbitos administrados. Debe justificarse la unicidad y no confundirse con una conveniencia sintáctica.

## Patrones relacionados

- **Monostate** comparte estado entre distintas instancias.
- **Service Locator** centraliza búsquedas y también oculta dependencias.
- **Dependency Injection** hace visible la dependencia y administra su alcance.
- **Abstract Factory** puede ser única, pero no necesita implementar Singleton.

## Material de esta carpeta

El [README](README.md) y los ejemplos de auditoría y caché permiten analizar tanto la unicidad como sus riesgos. En especial, debe evaluarse el estado mutable y el comportamiento concurrente.

## Referencia principal

Gamma, E., Helm, R., Johnson, R. y Vlissides, J. (1994). *Design Patterns: Elements of Reusable Object-Oriented Software*. Addison-Wesley.
