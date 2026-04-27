# Ejemplo: consultas SQL dinamicas

## Patron aplicado

Builder

## Problematica

Una consulta combina columnas, tabla, filtros y orden. Construirla con parametros sueltos es propenso a errores de orden.

## Como la atiende el patron

El builder encadena pasos semanticos y valida que exista la tabla antes de construir la consulta.

## Organizacion del proyecto

- `src/main`: contiene el punto de entrada del sistema.
- `src/pattern`: contiene las clases que implementan el patron aplicado al problema.

## Ejecutar

```bash
mkdir out
javac -encoding UTF-8 -d out src/pattern/*.java src/main/*.java
java -cp out main.Main
```
