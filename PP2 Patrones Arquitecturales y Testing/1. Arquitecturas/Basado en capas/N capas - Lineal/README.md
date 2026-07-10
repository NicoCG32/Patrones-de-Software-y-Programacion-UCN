# Arquitectura De N Capas: Flujo Lineal

Consulta la [explicación detallada](EXPLICACIÓN.md) para estudiar su propósito, uso, evolución, ventajas y limitaciones.

## Propósito

Mostrar que una arquitectura por capas no está limitada a dos o tres niveles. Puede existir cualquier cantidad de capas si cada una agrega una responsabilidad real y mantiene un flujo de dependencia ordenado.

## Estructura

```text
Entrada -> Validación -> Aplicación -> Dominio -> Persistencia -> Salida
```

La idea importante es que siempre puede agregarse un componente que se relacione de forma lineal con el resto:

```text
Capa A -> Capa B -> Capa C
```

puede convertirse en:

```text
Capa A -> Capa B -> Nueva Capa -> Capa C
```

Esto es aceptable si la nueva capa tiene una responsabilidad clara. No es aceptable si solo agrega indirección sin aportar criterio de diseño.

## Regla principal

Cada capa debe conocer su siguiente colaborador, no toda la cadena completa.

## Ejecución

```bash
javac -encoding UTF-8 src/*.java
java -cp src Main
```

## Lectura esperada

El ejemplo procesa una inscripción pasando por entrada, validación, aplicación, dominio, persistencia y salida. Cada clase participa en una etapa lineal.
