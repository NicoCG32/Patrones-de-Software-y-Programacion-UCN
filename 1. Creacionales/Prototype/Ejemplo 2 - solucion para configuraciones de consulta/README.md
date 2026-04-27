# Ejemplo: configuraciones de consulta

## Patron aplicado

Prototype

## Problematica

Una consulta base costosa se reutiliza con filtros distintos.

## Como la atiende el patron

El prototipo conserva la configuracion base y permite obtener variantes mediante copia.

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

