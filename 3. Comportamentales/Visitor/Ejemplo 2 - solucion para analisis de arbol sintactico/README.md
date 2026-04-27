# Ejemplo: analisis de arbol sintactico

## Patron aplicado

Visitor

## Problematica

Un AST estable necesita nuevas operaciones como impresion o validacion.

## Como la atiende el patron

El visitor recorre nodos concretos sin modificar sus clases.

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

