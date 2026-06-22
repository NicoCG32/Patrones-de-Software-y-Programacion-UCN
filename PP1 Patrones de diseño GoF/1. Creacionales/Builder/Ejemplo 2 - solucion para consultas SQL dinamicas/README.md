# Ejemplo: consultas SQL dinamicas

## Patron aplicado

Builder

## Problematica

Una consulta combina columnas, tabla, filtros y orden. Construirla con parametros sueltos es propenso a errores de orden.

## Como la atiende el patron

El builder encadena pasos semanticos y valida que exista la tabla antes de construir la consulta.

## Organizacion del proyecto

- `src/main`: contiene el punto de entrada del sistema.
- `src/pattern/PatternImplementation.java`: contiene todas las clases e interfaces del patron en un solo archivo.

## Ejecutar

```bash
mkdir out
javac -encoding UTF-8 -d out src/pattern/*.java src/main/*.java
java -cp out main.Main
```

## UML de la implementacion

![UML de la implementacion](UML.png)
