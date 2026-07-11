# Diagrama de componentes - Visitor

Este archivo conserva el DSL PlantUML utilizado para generar `ComponentDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Visitor - diagrama de componentes
left to right direction
skinparam componentStyle rectangle

component "Cliente" as Client
interface "Element" as IElement
component "Elemento concreto" as Element
interface "Visitor" as IVisitor
component "Visitor concreto" as Visitor
component "Operacion externa" as Operation

Client --> IElement : accept(visitor)
Element ..|> IElement
Visitor ..|> IVisitor
Element --> IVisitor : double dispatch
Visitor --> Operation : ejecuta comportamiento
@enduml
```
