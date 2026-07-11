# Diagrama de clases - MVC con interfaces

Este archivo conserva el DSL PlantUML utilizado para generar `ClassDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title MVC con interfaces - diagrama de clases
left to right direction
interface IVista {
  +mostrar(datos)
}
interface IModelo {
  +actualizar()
  +obtenerDatos()
}
class VistaConcreta
class ModeloConcreto
class Controlador {
  +manejarEvento()
}
VistaConcreta ..|> IVista
ModeloConcreto ..|> IModelo
VistaConcreta --> Controlador
Controlador --> IVista
Controlador --> IModelo
@enduml
```
