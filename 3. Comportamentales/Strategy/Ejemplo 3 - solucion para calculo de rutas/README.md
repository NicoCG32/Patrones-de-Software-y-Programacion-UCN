# Ejemplo: calculo de rutas

## Patron aplicado

Strategy

## Problematica

La ruta puede priorizar rapidez o costo.

## Como la atiende el patron

El navegador delega el calculo en una estrategia seleccionable.

## Organizacion del proyecto

- `src/main`: contiene el punto de entrada del sistema.
- `src/pattern`: contiene las clases que implementan el patron aplicado al problema.

## Ejecutar

```bash
mkdir out
javac -encoding UTF-8 -d out src/pattern/*.java src/main/*.java
java -cp out main.Main
```

## UML de la implementacion

![UML de la implementacion](UML.png)

