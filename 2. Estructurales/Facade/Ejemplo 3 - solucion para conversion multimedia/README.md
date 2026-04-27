# Ejemplo: conversion multimedia

## Patron aplicado

Facade

## Problematica

Convertir video requiere decodificar, aplicar filtros y exportar.

## Como la atiende el patron

La fachada expone una operacion de conversion de alto nivel.

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

