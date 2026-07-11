# Diagrama de componentes - MVC Web

Este archivo conserva el DSL PlantUML utilizado para generar `ComponentDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title MVC Web - diagrama de componentes
left to right direction
skinparam componentStyle rectangle

actor Navegador
component "Router" as Router
component "Controller" as Controller
component "Model / Service" as Model
component "View / Template" as Template
database "Datos" as Database

Navegador --> Router : request HTTP
Router --> Controller : enruta accion
Controller --> Model : caso de uso
Model --> Database : persistencia
Controller --> Template : selecciona vista
Template --> Navegador : response HTML/JSON
@enduml
```
