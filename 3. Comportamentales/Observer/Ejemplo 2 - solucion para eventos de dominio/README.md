# Ejemplo: eventos de dominio

## Patron aplicado

Observer

## Problematica

Varios modulos deben reaccionar cuando se crea una orden.

## Como la atiende el patron

El publicador notifica a listeners desacoplados como inventario y facturacion.

## Organizacion del proyecto

- `src/main`: contiene el punto de entrada del sistema.
- `src/pattern`: contiene las clases que implementan el patron aplicado al problema.

## Ejecutar

```bash
mkdir out
javac -encoding UTF-8 -d out src/pattern/*.java src/main/*.java
java -cp out main.Main
```
