# Ejemplo: Implementacion Generica

## Patron aplicado

Builder

## Problematica

Implementacion generica para comprender como construir un objeto complejo paso a paso sin exponer su proceso de ensamblaje.

## Como la atiende el patron

El ejemplo mantiene nombres generales para que la estructura del patron sea visible antes de estudiar variantes de dominio.

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

