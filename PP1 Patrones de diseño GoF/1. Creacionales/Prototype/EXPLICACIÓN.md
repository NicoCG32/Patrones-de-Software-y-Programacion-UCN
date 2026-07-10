# Explicación Detallada - Prototype

## Para qué sirve

Prototype crea nuevos objetos a partir de una instancia existente que actúa como prototipo. Es útil cuando configurar un objeto desde cero es costoso, cuando sus variantes se conocen en tiempo de ejecución o cuando copiar un estado base comunica mejor la intención que repetir su construcción.

El patrón desplaza la responsabilidad de creación desde una clase externa hacia el propio objeto o un servicio de copia.

## Cómo se usa

La estructura contiene un contrato como `copiar()` y prototipos concretos que producen una nueva instancia equivalente. Un registro opcional asocia claves con prototipos preconfigurados.

La decisión crítica es la profundidad de la copia:

- **Copia superficial**: duplica el objeto, pero comparte referencias internas.
- **Copia profunda**: duplica también el estado mutable alcanzable que debe ser independiente.

No existe una profundidad universalmente correcta. Los objetos inmutables pueden compartirse con seguridad; las colecciones mutables normalmente requieren una nueva colección y, según el dominio, copias de sus elementos.

Una implementación debe declarar qué propiedades se conservan, cuáles se regeneran y si la identidad cambia. Copiar una entidad persistente con el mismo identificador puede violar reglas del dominio.

## Por qué se usa

Prototype evita repetir una secuencia compleja de configuración y permite incorporar variantes registrando datos, no necesariamente creando nuevas fábricas o subclases. También puede mejorar rendimiento cuando la inicialización original es más costosa que una copia segura.

## Contextos de aplicación

Se utiliza en editores gráficos, plantillas, configuraciones de consulta, escenarios de prueba, simulaciones y objetos derivados de modelos cargados. Resulta especialmente útil cuando el conjunto de prototipos se configura dinámicamente.

No conviene cuando la copia es ambigua, el grafo tiene ciclos difíciles de manejar, existen recursos no copiables o el constructor expresa mejor las invariantes.

## Ventajas y desventajas

### Ventajas

- Reduce el costo y la repetición de una construcción compleja.
- Permite variantes configuradas en tiempo de ejecución.
- Evita jerarquías de fábricas para combinaciones de estado.
- Puede ofrecer una API natural para duplicar plantillas.

### Desventajas

- La copia profunda puede ser compleja y costosa.
- Compartir estado mutable accidentalmente produce errores sutiles.
- Identidades, conexiones y recursos externos requieren políticas explícitas.
- El mecanismo `Cloneable` de Java posee un contrato limitado y propenso a errores.

## Origen y evolución

Prototype fue catalogado por GoF en 1994. Su contexto histórico incluye sistemas gráficos y frameworks donde las clases concretas disponibles podían variar durante la ejecución.

En Java, el uso temprano de `Object.clone()` dio paso con frecuencia a constructores de copia, métodos estáticos, serialización controlada o mapeadores. Esta evolución responde a la necesidad de hacer explícita la semántica de copia en vez de depender de una copia superficial implícita.

## Estado actual

El patrón continúa vigente, pero se recomienda expresar la política de copia con una API del dominio. Los records y objetos inmutables simplifican el problema: pueden reutilizar partes seguras y crear una nueva instancia solo con los cambios necesarios.

## Patrones relacionados

- **Builder** crea una variante paso a paso desde datos explícitos.
- **Factory Method** delega la selección de una clase.
- **Memento** captura estado para restauración, no necesariamente para crear una entidad nueva.
- **Flyweight** comparte estado para ahorrar memoria; Prototype busca independencia mediante copia.

## Material de esta carpeta

El [README](README.md) y los ejemplos muestran copias de configuraciones y figuras. Al revisarlos, se debe identificar qué atributos son mutables y comprobar que modificar la copia no altere el original.

## Referencia principal

Gamma, E., Helm, R., Johnson, R. y Vlissides, J. (1994). *Design Patterns: Elements of Reusable Object-Oriented Software*. Addison-Wesley.
