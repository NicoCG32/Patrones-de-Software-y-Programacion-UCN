# Diagrama de secuencia - MVC Web

Este archivo conserva el DSL PlantUML utilizado para generar `SequenceDiagrama.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title MVC Web - diagrama de secuencia
actor Navegador
participant Router
participant WebController
participant ApplicationService
participant TemplateView
Navegador -> Router : request HTTP
Router -> WebController : action()
WebController -> ApplicationService : casoUso()
ApplicationService --> WebController : modelo
WebController -> TemplateView : render(modelo)
TemplateView --> WebController : HTML
WebController --> Navegador : response
@enduml
```
