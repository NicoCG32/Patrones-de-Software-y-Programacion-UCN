# Ejemplo: auditoria de items

## Patron aplicado

Visitor

## Problematica

Items distintos necesitan auditoria transversal sin mezclarla con su modelo.

## Como la atiende el patron

El visitor agrega la operacion de auditoria para cada tipo concreto.

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

