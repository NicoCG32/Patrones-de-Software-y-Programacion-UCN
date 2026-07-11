# Diagrama de componentes - MVC

Este archivo conserva el DSL PlantUML utilizado para generar `ComponentDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title MVC - diagrama de componentes
left to right direction
skinparam componentStyle rectangle

actor Usuario
component "View" as View
component "Controller" as Controller
component "Model" as Model
component "Estado / Dominio" as State

Usuario --> View : interactua
View --> Controller : eventos
Controller --> Model : comandos/consultas
Model --> State : modifica o consulta
Model --> View : cambios observables
@enduml
```
