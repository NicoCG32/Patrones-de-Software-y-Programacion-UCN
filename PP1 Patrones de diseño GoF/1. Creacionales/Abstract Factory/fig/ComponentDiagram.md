# Diagrama de componentes - Abstract Factory

Este archivo conserva el DSL PlantUML utilizado para generar `ComponentDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Abstract Factory - diagrama de componentes
left to right direction
skinparam componentStyle rectangle

component "Cliente" as Client
interface "AbstractFactory" as IFactory
interface "Producto A" as IProductA
interface "Producto B" as IProductB
component "Fabrica concreta" as ConcreteFactory
component "Familia concreta" as Family {
  component "ProductoA concreto" as ProductA
  component "ProductoB concreto" as ProductB
}

Client --> IFactory : solicita objetos
Client --> IProductA : usa abstraccion
Client --> IProductB : usa abstraccion
ConcreteFactory ..|> IFactory
ConcreteFactory --> ProductA : crea
ConcreteFactory --> ProductB : crea
ProductA ..|> IProductA
ProductB ..|> IProductB
@enduml
```
