# MVC CLI

Consulta la [explicación detallada](EXPLICACIÓN.md) para estudiar su propósito, uso, evolución, ventajas y limitaciones.

## Propósito

Mostrar que MVC también puede aplicarse a consola. La vista CLI no debe contener reglas de negocio; solo interpreta entradas textuales y delega en el controlador.

## Estructura

```text
CommandLineView -> TaskController -> TaskModel
```

- `CommandLineView`: simula comandos de consola.
- `TaskController`: recibe comandos semánticos y coordina.
- `TaskModel`: mantiene la lista de tareas.

## Regla principal

La vista CLI no manipula directamente la lista. El controlador decide qué operación del modelo corresponde a cada comando.

## Ejecución

```bash
javac -encoding UTF-8 src/*.java
java -cp src Main
```

## Lectura esperada

El ejemplo usa comandos simulados para evitar interacción manual y permitir ejecución reproducible.
