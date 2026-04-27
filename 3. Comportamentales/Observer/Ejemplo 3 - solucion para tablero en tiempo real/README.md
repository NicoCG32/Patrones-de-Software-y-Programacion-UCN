# Ejemplo: tablero en tiempo real

## Patron aplicado

Observer

## Problematica

Graficos y contadores deben actualizarse cuando cambia una metrica.

## Como la atiende el patron

El dashboard notifica a todos los widgets observadores.

## Organizacion del proyecto

- `src/main`: contiene el punto de entrada del sistema.
- `src/pattern`: contiene las clases que implementan el patron aplicado al problema.

## Ejecutar

```bash
mkdir out
javac -encoding UTF-8 -d out src/pattern/*.java src/main/*.java
java -cp out main.Main
```
