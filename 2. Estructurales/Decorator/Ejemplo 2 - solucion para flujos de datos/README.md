# Ejemplo: flujos de datos

## Patron aplicado

Decorator

## Problematica

Un stream puede requerir buffer y cifrado en combinaciones variables.

## Como la atiende el patron

Cada decorador agrega una responsabilidad y mantiene la interfaz de lectura.

## Organizacion del proyecto

- `src/main`: contiene el punto de entrada del sistema.
- `src/pattern`: contiene las clases que implementan el patron aplicado al problema.

## Ejecutar

```bash
mkdir out
javac -encoding UTF-8 -d out src/pattern/*.java src/main/*.java
java -cp out main.Main
```
