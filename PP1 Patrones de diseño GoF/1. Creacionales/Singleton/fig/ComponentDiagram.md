# Diagrama de componentes - Singleton

Este archivo conserva el DSL PlantUML utilizado para generar `ComponentDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Singleton - diagrama de componentes
left to right direction
skinparam componentStyle rectangle

component "Cliente A" as ClientA
component "Cliente B" as ClientB
component "Singleton" as Singleton
component "Estado compartido" as State

ClientA --> Singleton : getInstance()
ClientB --> Singleton : getInstance()
Singleton --> State : administra
note bottom of Singleton
Una unica instancia coordina
el acceso al recurso compartido.
end note
@enduml
```
