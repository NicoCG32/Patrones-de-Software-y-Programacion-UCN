# Diagrama de clases - MVC

Este archivo conserva el DSL PlantUML utilizado para generar `ClassDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title MVC - diagrama de clases
left to right direction
class View {
  +render(modelo)
  +capturarEvento()
}
class Controller {
  +handle(evento)
}
class Model {
  +actualizar()
  +consultarEstado()
}
class DomainState {
  +datos
}
View --> Controller
Controller --> Model
Model --> DomainState
Model ..> View : notifica cambios
@enduml
```
