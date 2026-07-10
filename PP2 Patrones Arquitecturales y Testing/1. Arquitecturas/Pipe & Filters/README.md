# Pipe & Filters

Consulta la [explicación detallada](EXPLICACIÓN.md) para estudiar su propósito, uso, evolución, ventajas y limitaciones.

## Propósito

Procesar datos mediante una secuencia de filtros independientes. Cada filtro recibe una entrada, aplica una transformación y entrega una salida al siguiente filtro.

## Problema que resuelve

Cuando un procesamiento tiene varios pasos encadenados, mezclar todo en un método grande dificulta probar, reordenar o reutilizar etapas.

## Estructura del ejemplo

```text
texto crudo -> limpiar -> normalizar -> separar palabras -> salida
```

- `LimpiarFiltro`: elimina espacios sobrantes.
- `MinusculasFiltro`: normaliza mayúsculas.
- `SepararPalabrasFiltro`: transforma texto en palabras separadas por línea.

## Regla de dependencia

Cada filtro conoce solo su entrada y salida. No conoce el pipeline completo ni los filtros vecinos.

## Ejecución

```bash
javac -encoding UTF-8 src/*.java
java -cp src Main
```

## Lectura esperada

La salida muestra el texto transformado por etapas. La gracia del patrón es que se puede agregar, quitar o reordenar filtros sin reescribir todo el flujo.
