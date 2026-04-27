# Ejemplo: auditoria centralizada

## Patron aplicado

Singleton

## Problematica

Los eventos deben registrarse en un unico flujo ordenado.

## Como la atiende el patron

El singleton mantiene una unica instancia con secuencia compartida para toda la aplicacion.

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

