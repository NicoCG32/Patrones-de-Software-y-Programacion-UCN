# Strategy

Consulta la [explicación detallada](EXPLICACIÓN.md) para estudiar su propósito, uso, evolución, ventajas y limitaciones.

## Proposito

Encapsular una familia de algoritmos intercambiables detras de una interfaz comun.

## Problema que resuelve

Una clase acumula condicionales para elegir algoritmos. Cada nueva variante obliga a modificar esa clase y aumenta el acoplamiento.

## Idea de solucion

El contexto delega el algoritmo en una interfaz `Strategy`. Las estrategias concretas implementan variantes del algoritmo y pueden asignarse por constructor, reemplazarse en runtime o seleccionarse mediante una factory.

## Variantes implementadas

- `Ejemplo 1 - Implementacion Generica`: estructura minima del patron.
- `Ejemplo 2 - solucion para criterios de ordenamiento`: estrategia aplicada a ordenamiento.
- `Ejemplo 3 - solucion para calculo de rutas`: estrategia aplicada a rutas.
- `Ejemplo 4 - Strategy intercambiable en runtime`: el contexto cambia de estrategia durante la ejecucion.
- `Ejemplo 5 - Strategy seleccionado por factory`: una factory/mapa selecciona la estrategia antes de entregarla al contexto.

## Utilidades concretas

- **Intercambio en runtime:** adecuado cuando el usuario, configuracion o estado del sistema cambia el algoritmo activo durante la ejecucion.
- **Seleccion por factory/mapa:** adecuado cuando un codigo, tipo o entrada externa debe resolverse a una estrategia concreta sin llenar el contexto de condicionales.

## Palabras clave para reconocerlo

- `algoritmo intercambiable`
- `familia de algoritmos`
- `evitar condicionales`
- `contexto`
- `politica`
- `seleccion dinamica`
- `factory de estrategias`
- `cambio en runtime`

## Criterio academico

La senal central es que el comportamiento variable es un algoritmo completo, no solo un dato. El contexto conserva la responsabilidad de coordinar el caso de uso, pero delega la parte variable en una abstraccion.
