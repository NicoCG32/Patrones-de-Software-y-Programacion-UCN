# Arquitectura Basada En Capas

Consulta la [explicación detallada](EXPLICACIÓN.md) para estudiar su propósito, uso, evolución, ventajas y limitaciones.

## Propósito

Organizar el sistema en niveles de responsabilidad. Una capa ofrece servicios a la capa superior y delega trabajo hacia la capa inferior. La regla central es que el flujo de dependencia debe ser comprensible y controlado.

## Variantes incluidas

| Variante | Estructura | Idea principal |
| --- | --- | --- |
| [2 capas](<2 capas - Frontend Backend/README.md>) | `Frontend -> Backend` | Separar presentación cliente y lógica del servidor. |
| [3 capas](<3 capas - Vista Servicio Persistencia/README.md>) | `Vista -> Servicio -> Persistencia` | Separar interfaz, caso de uso y almacenamiento. |
| [N capas](<N capas - Lineal/README.md>) | `Capa 1 -> Capa 2 -> ... -> Capa N` | Insertar componentes intermedios sin romper el flujo lineal de dependencias. |

## Ejemplo base

El ejemplo de `src/` muestra una variante simple cercana a tres capas:

```text
Main -> TareaController -> TareaService -> TareaRepository -> Tarea
```

- `Main`: punto de entrada.
- `TareaController`: simula la capa de presentación.
- `TareaService`: contiene el caso de uso.
- `TareaRepository`: simula infraestructura de datos.
- `Tarea`: representa el modelo de dominio.

## Nomenclatura

La [explicación detallada](EXPLICACIÓN.md#nomenclaturas-comunes) distingue las denominaciones más habituales:

```text
Controller -> Service -> Repository o DAO
```

- `Controller` adapta la entrada y salida.
- `Service` coordina casos de uso o expresa servicios de dominio.
- `DAO` encapsula acceso técnico a datos.
- `Repository` presenta persistencia mediante vocabulario del dominio.
- `DTO` transporta datos y `Mapper` convierte entre modelos.
- `Gateway` o `Client` encapsulan integraciones externas.

`DAO` y `Repository` no son sinónimos ni deben coexistir obligatoriamente. Cada tipo debe introducir una responsabilidad distinta.

## Regla de dependencia

```text
presentación -> aplicación/servicio -> persistencia o infraestructura
```

La presentación no debería crear directamente objetos de persistencia si existe una capa de aplicación encargada de coordinar el caso de uso.

## Ejecución del ejemplo base

```bash
javac -encoding UTF-8 src/*.java
java -cp src Main
```

Cada variante tiene su propio `README.md` y su propio `src/Main.java`.

## Lectura académica

Una arquitectura por capas no significa crear carpetas por crear carpetas. Significa decidir qué responsabilidades pueden depender de cuáles. Si una capa superior conoce detalles concretos de una capa técnica, el diseño pierde capacidad de cambio.
