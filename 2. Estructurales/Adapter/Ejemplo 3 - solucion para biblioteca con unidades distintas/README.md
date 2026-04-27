# Ejemplo: biblioteca con unidades distintas

## Patron aplicado

Adapter

## Problematica

La biblioteca calcula distancias en millas, pero el dominio trabaja en kilometros.

## Como la atiende el patron

El adaptador concentra la conversion de unidades y protege al cliente.

## Organizacion del proyecto

- `src/main`: contiene el punto de entrada del sistema.
- `src/pattern`: contiene las clases que implementan el patron aplicado al problema.

## Ejecutar

```bash
mkdir out
javac -encoding UTF-8 -d out src/pattern/*.java src/main/*.java
java -cp out main.Main
```
