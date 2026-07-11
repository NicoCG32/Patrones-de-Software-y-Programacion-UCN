# Diagrama de componentes - MVC con interfaces

Este archivo conserva el DSL PlantUML utilizado para generar `ComponentDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title MVC con interfaces - diagrama de componentes
left to right direction
skinparam componentStyle rectangle

component "Vista" as View
component "Controlador" as Controller
interface "IModelo" as IModel
interface "IVista" as IView
component "Modelo concreto" as Model
component "Vista concreta" as ViewImpl

ViewImpl ..|> IView
Model ..|> IModel
View --> Controller : eventos
Controller --> IModel : usa contrato
Controller --> IView : actualiza contrato
@enduml
```
