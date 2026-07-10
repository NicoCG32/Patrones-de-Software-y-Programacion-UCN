# Arquitectura Hexagonal

Consulta la [explicación detallada](EXPLICACIÓN.md) para estudiar su propósito, uso, evolución, ventajas y limitaciones.

## Propósito

Proteger el dominio de detalles externos mediante puertos y adaptadores. El centro contiene reglas de negocio; los bordes traducen entrada, salida, persistencia o servicios externos.

## Problema que resuelve

Si el dominio depende directamente de consola, base de datos o frameworks, las reglas centrales quedan atadas a detalles técnicos. Hexagonal invierte esa relación: el dominio define lo que necesita y la infraestructura implementa esos puertos.

## Estructura del ejemplo

```text
Main -> PedidoController -> PedidoService -> InventarioPort
                                      InventarioEnMemoriaAdapter
```

- `PedidoService`: caso de uso y regla central.
- `InventarioPort`: puerto requerido por el caso de uso.
- `InventarioEnMemoriaAdapter`: adaptador concreto.
- `PedidoController`: adaptador de entrada simplificado.

## Regla de dependencia

```text
adaptadores -> aplicación/dominio -> puertos
adaptadores -> puertos
```

La aplicación no depende de la implementación concreta del inventario. Depende del puerto.

## Ejecución

```bash
javac -encoding UTF-8 src/*.java
java -cp src Main
```

## Lectura esperada

El ejemplo reserva stock mediante un puerto. Cambiar memoria por archivo, base de datos o API no debería modificar `PedidoService`.
