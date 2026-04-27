# Ejemplo: arranque de aplicacion

## Patron aplicado

Facade

## Problematica

Iniciar la aplicacion exige cargar configuracion, iniciar logs y conectar base de datos.

## Como la atiende el patron

La fachada ofrece `start()` y oculta la coordinacion del subsistema.

## Organizacion del proyecto

- `src/main`: contiene el punto de entrada del sistema.
- `src/pattern`: contiene las clases que implementan el patron aplicado al problema.

## Ejecutar

```bash
mkdir out
javac -encoding UTF-8 -d out src/pattern/*.java src/main/*.java
java -cp out main.Main
```
