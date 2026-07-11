# Diagrama de componentes - Prototype

Este archivo conserva el DSL PlantUML utilizado para generar `ComponentDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Prototype - diagrama de componentes
left to right direction
skinparam componentStyle rectangle

component "Cliente" as Client
interface "Prototype" as IPrototype
component "Prototipo concreto" as ConcretePrototype
component "Objeto clonado" as Clone

Client --> IPrototype : clone/copy()
ConcretePrototype ..|> IPrototype
ConcretePrototype --> Clone : crea copia
Client --> Clone : configura variante
@enduml
```
