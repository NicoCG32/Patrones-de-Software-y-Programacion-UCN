# Ejemplo: datos de prueba

## Patron aplicado

Builder

## Problematica

Las pruebas necesitan usuarios con valores por defecto, pero con variaciones puntuales por escenario.

## Como la atiende el patron

El builder entrega un objeto valido por defecto y permite especializar solo lo relevante.

## Organizacion del proyecto

- `src/main`: contiene el punto de entrada del sistema.
- `src/pattern`: contiene las clases que implementan el patron aplicado al problema.

## Ejecutar

```bash
mkdir out
javac -encoding UTF-8 -d out src/pattern/*.java src/main/*.java
java -cp out main.Main
```
