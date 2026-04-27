# Ejemplo: cache compartida

## Patron aplicado

Singleton

## Problematica

Cargar metadatos varias veces desperdicia recursos y puede generar inconsistencias.

## Como la atiende el patron

El singleton centraliza una cache reutilizada por todos los clientes.

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

