# Ejemplo: procesamiento de pedidos

## Patron aplicado

Template Method

## Problematica

El orden de validar, cobrar, entregar y notificar debe conservarse.

## Como la atiende el patron

La plantilla fija la secuencia y permite variar cobro y entrega.

## Organizacion del proyecto

- `src/main`: contiene el punto de entrada del sistema.
- `src/pattern`: contiene las clases que implementan el patron aplicado al problema.

## Ejecutar

```bash
mkdir out
javac -encoding UTF-8 -d out src/pattern/*.java src/main/*.java
java -cp out main.Main
```
