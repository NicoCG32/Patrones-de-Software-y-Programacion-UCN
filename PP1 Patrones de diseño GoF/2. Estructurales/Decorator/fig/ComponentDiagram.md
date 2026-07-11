# Diagrama de componentes - Decorator

Este archivo conserva el DSL PlantUML utilizado para generar `ComponentDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Decorator - diagrama de componentes
left to right direction
skinparam componentStyle rectangle

component "Cliente" as Client
interface "Component" as IComponent
component "Componente concreto" as ConcreteComponent
component "Decorator base" as Decorator
component "Decorator concreto" as ConcreteDecorator

Client --> IComponent : usa interfaz comun
ConcreteComponent ..|> IComponent
Decorator ..|> IComponent
Decorator --> IComponent : envuelve
ConcreteDecorator -up-|> Decorator
@enduml
```
