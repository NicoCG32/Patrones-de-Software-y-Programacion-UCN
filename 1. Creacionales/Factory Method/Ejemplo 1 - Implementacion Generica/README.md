# Ejemplo: Implementacion Generica

## Patron aplicado

Factory Method

## Problematica

Implementacion generica para comprender como una subclase decide que producto concreto crear.

## Como la atiende el patron

El ejemplo mantiene nombres generales para que la estructura del patron sea visible antes de estudiar variantes de dominio.

## Organizacion del proyecto

- `src/main`: contiene el punto de entrada del sistema.
- `src/pattern/PatternImplementation.java`: contiene todas las clases e interfaces del patron en un solo archivo.

## Ejecutar

```bash
mkdir out
javac -encoding UTF-8 -d out src/pattern/*.java src/main/*.java
java -cp out main.Main
```

## UML de la implementacion

![UML de la implementacion](UML.png)
