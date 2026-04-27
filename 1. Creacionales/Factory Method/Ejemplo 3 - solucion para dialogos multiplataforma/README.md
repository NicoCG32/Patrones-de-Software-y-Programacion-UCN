# Ejemplo: dialogos multiplataforma

## Patron aplicado

Factory Method

## Problematica

El dialogo tiene comportamiento comun, pero el boton concreto depende de la plataforma.

## Como la atiende el patron

Cada dialogo concreto implementa el metodo fabrica para producir su boton nativo.

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

