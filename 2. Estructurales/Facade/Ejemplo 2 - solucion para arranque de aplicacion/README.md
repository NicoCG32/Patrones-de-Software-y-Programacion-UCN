# Ejemplo: arranque de aplicacion

## Patron aplicado

Facade

## Problematica

Iniciar la aplicacion exige cargar configuracion, iniciar logs y conectar base de datos.

## Como la atiende el patron

La fachada ofrece `start()` y oculta la coordinacion del subsistema.

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
