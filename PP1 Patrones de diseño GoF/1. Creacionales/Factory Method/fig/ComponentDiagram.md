# Diagrama de componentes - Factory Method

Este archivo conserva el DSL PlantUML utilizado para generar `ComponentDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Factory Method - diagrama de componentes
left to right direction
skinparam componentStyle rectangle

component "Cliente" as Client
component "Creator" as Creator
component "ConcreteCreator" as ConcreteCreator
interface "Product" as IProduct
component "ConcreteProduct" as ConcreteProduct

Client --> Creator : ejecuta operacion
ConcreteCreator -up-|> Creator
Creator --> IProduct : trabaja con producto
ConcreteCreator --> ConcreteProduct : factoryMethod()
ConcreteProduct ..|> IProduct
@enduml
```
