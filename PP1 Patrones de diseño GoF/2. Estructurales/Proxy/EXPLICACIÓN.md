# Explicación Detallada - Proxy

## Para qué sirve

Proxy proporciona un sustituto que conserva la interfaz de un objeto real y controla el acceso a él. Puede diferir su creación, verificar permisos, representar un recurso remoto, almacenar resultados o registrar interacciones.

Cliente y proxy comparten el contrato del **Subject**. La diferencia respecto de una llamada directa es una política de acceso que debe ser transparente en la medida permitida por la semántica.

## Cómo se usa

Participan:

- **Subject**: contrato común.
- **RealSubject**: objeto que realiza el trabajo.
- **Proxy**: controla cuándo y cómo delegar.
- **Client**: usa el contrato sin requerir el tipo concreto.

Variantes frecuentes:

- **Virtual**: crea o carga el recurso solo cuando se necesita.
- **Protection**: autoriza la operación.
- **Remote**: representa un objeto o servicio en otro proceso.
- **Caching**: reutiliza resultados bajo una política de validez.
- **Smart reference**: cuenta, registra o administra el acceso.

Un proxy debe definir fallos, concurrencia y consistencia. Un proxy remoto no puede hacer que la red sea indistinguible de una llamada local: latencia, indisponibilidad y reintentos forman parte del contrato operativo.

## Por qué se usa

Separa la lógica principal de políticas técnicas de acceso. También permite introducir esas políticas sin modificar al sujeto ni a sus consumidores.

## Contextos de aplicación

Se usa en ORM con carga diferida, clientes remotos, autorización, cachés, instrumentación y objetos costosos. Los frameworks pueden generarlo dinámicamente para transacciones o interceptores.

No conviene cuando oculta costos importantes, hace impredecible una operación simple o mezcla muchas políticas en una cadena difícil de observar.

## Ventajas y desventajas

### Ventajas

- Introduce control sin cambiar al objeto real.
- Permite inicialización diferida y caché.
- Aísla detalles remotos o de seguridad.
- Conserva el contrato para el cliente.

### Desventajas

- Agrega latencia e indirección.
- Puede ocultar llamadas remotas o efectos secundarios.
- Las políticas de caché e invalidación son complejas.
- Los proxies dinámicos dificultan rastrear el flujo.
- La transparencia completa es imposible en sistemas distribuidos.

## Origen y evolución

Proxy fue descrito en el catálogo GoF de 1994. Sus variantes originales ya incluían referencias remotas, virtuales y de protección.

La evolución de middleware, ORM, contenedores y AOP extendió el uso de proxies generados. Hoy pueden basarse en interfaces, subclases dinámicas o instrumentación. Esta automatización reduce código, pero obliga a comprender límites como métodos finales, identidad, serialización y contexto transaccional.

## Estado actual

Proxy está ampliamente presente, incluso cuando el desarrollador no lo escribe. La práctica actual exige hacer visibles las diferencias operativas: una interfaz uniforme no debería inducir a creer que una llamada remota tiene el mismo costo y confiabilidad que una local.

## Patrones relacionados

- **Decorator** agrega responsabilidades funcionales y suele permitir composición explícita.
- **Adapter** cambia la interfaz.
- **Facade** simplifica un subsistema.
- **Gateway** encapsula acceso a un sistema externo y puede usar internamente un proxy.

## Material de esta carpeta

El [README](README.md) clasifica las variantes incluidas. Los ejemplos cubren protección, carga virtual, conteo, caché y acceso remoto; deben compararse por la política que antecede a la delegación.

## Referencia principal

Gamma, E., Helm, R., Johnson, R. y Vlissides, J. (1994). *Design Patterns: Elements of Reusable Object-Oriented Software*. Addison-Wesley.
