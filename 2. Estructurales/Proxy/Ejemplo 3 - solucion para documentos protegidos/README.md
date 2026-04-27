# Ejemplo: documentos protegidos

## Patron aplicado

Proxy

## Problematica

Un documento sensible requiere control de permisos antes de abrirse.

## Como la atiende el patron

El proxy valida el rol y solo delega al documento real si corresponde.

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

