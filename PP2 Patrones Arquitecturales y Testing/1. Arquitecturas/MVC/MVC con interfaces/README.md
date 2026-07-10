# MVC Con Interfaces

Consulta la [explicación detallada](EXPLICACIÓN.md) para estudiar su propósito, uso, evolución, ventajas y limitaciones.

## Propósito

Mostrar MVC usando contratos. El controlador depende de interfaces, no de clases concretas, por lo que la vista o el modelo pueden reemplazarse sin reescribir la coordinación.

## Estructura

```text
IContadorView -> IContadorController -> IContadorModel
```

- `IContadorModel`: contrato del modelo.
- `IContadorView`: contrato de la vista.
- `IContadorController`: contrato del controlador.
- Implementaciones concretas: `ContadorModel`, `ConsoleContadorView`, `ContadorController`.

## Regla principal

Las interfaces hacen explícito qué necesita cada componente. Esto permite cambiar consola por GUI, o modelo en memoria por otro modelo, manteniendo el controlador estable.

## Ejecución

```bash
javac -encoding UTF-8 src/*.java
java -cp src Main
```
