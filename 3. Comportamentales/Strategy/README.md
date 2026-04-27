# Strategy

## Proposito

Encapsular una familia de algoritmos intercambiables detras de una interfaz comun.

## Problema que resuelve

Una clase acumula condicionales para elegir algoritmos. Cada nueva variante obliga a modificar esa clase.

## Idea de solucion

El contexto delega el calculo en una estrategia configurable. Cada algoritmo vive en una clase concreta.

## Interaccion entre clases

`Cart.total()` llama `strategy.apply(price)`. Cambiar la estrategia cambia el algoritmo sin modificar `Cart`.

El archivo `UML.puml` contiene dos vistas: un diagrama de clases, que muestra la estructura estatica, y un diagrama de secuencia, que muestra el flujo de mensajes entre objetos durante una ejecucion tipica.

## Palabras clave para reconocerlo

- `algoritmo intercambiable`
- `familia de algoritmos`
- `evitar condicionales`
- `contexto`
- `politica`
- `seleccion dinamica`

## Implementacion Java

Cada clase esta separada en un archivo para que la estructura del patron sea visible:

- `src/Cart.java`
- `src/DiscountStrategy.java`
- `src/Main.java`
- `src/NoDiscount.java`
- `src/PercentageDiscount.java`

Para compilar y ejecutar desde esta carpeta:

```bash
javac -encoding UTF-8 src/*.java
java -cp src Main
```

## Tres ejemplos de aplicacion

### Ejemplo 1: Implementacion Generica

**Problematica:** se necesita estudiar la estructura esencial del patron sin ruido accidental de un dominio especifico.

**Como la atiende el patron:** muestra la estructura basica para intercambiar algoritmos en un contexto.

### Ejemplo 2: Criterios de ordenamiento

**Problematica:** el usuario cambia entre precio y relevancia.

**Como la atiende el patron:** cada criterio es una estrategia intercambiable.

### Ejemplo 3: Calculo de rutas

**Problematica:** la ruta puede optimizar rapidez o costo.

**Como la atiende el patron:** el navegador delega en la estrategia seleccionada.

## Otras situaciones donde puede usarse

- Politicas de calculo intercambiables.
- Ranking u ordenamiento configurable.
- Reglas de negocio variables.
