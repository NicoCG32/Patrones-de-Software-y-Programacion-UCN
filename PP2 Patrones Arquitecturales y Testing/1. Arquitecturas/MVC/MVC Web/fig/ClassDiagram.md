# Diagrama de clases - MVC Web

Este archivo conserva el DSL PlantUML utilizado para generar `ClassDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title MVC Web - diagrama de clases
left to right direction
class Router {
  +route(request)
}
class WebController {
  +action()
}
class ApplicationService {
  +casoUso()
}
class TemplateView {
  +render(model)
}
class Repository {
  +buscar()
}
Router --> WebController
WebController --> ApplicationService
ApplicationService --> Repository
WebController --> TemplateView
@enduml
```
