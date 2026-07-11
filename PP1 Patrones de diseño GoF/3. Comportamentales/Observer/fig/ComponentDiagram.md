# Diagrama de componentes - Observer

Este archivo conserva el DSL PlantUML utilizado para generar `ComponentDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Observer - diagrama de componentes
left to right direction
skinparam componentStyle rectangle

component "Cliente" as Client
component "Subject" as Subject
interface "Observer" as IObserver
component "Observer concreto A" as ObserverA
component "Observer concreto B" as ObserverB

Client --> Subject : cambia estado
Subject --> IObserver : notifica update()
ObserverA ..|> IObserver
ObserverB ..|> IObserver
Subject o-- IObserver : suscripciones
@enduml
```
