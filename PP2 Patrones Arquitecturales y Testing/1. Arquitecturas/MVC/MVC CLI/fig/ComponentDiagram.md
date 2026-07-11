# Diagrama de componentes - MVC CLI

Este archivo conserva el DSL PlantUML utilizado para generar `ComponentDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title MVC CLI - diagrama de componentes
left to right direction
skinparam componentStyle rectangle

actor Usuario
component "Terminal" as Terminal
component "Vista CLI" as View
component "Controlador" as Controller
component "Modelo" as Model

Usuario --> Terminal : entrada/salida
Terminal --> View : texto
View --> Controller : comandos parseados
Controller --> Model : acciones
Model --> View : datos para imprimir
@enduml
```
