# Diagrama de clases - Factory Method

Este archivo conserva el DSL PlantUML utilizado para generar `ClassDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Factory Method - clases
interface Product {
  +operation(): String
}
class ConcreteProduct
abstract class Creator {
  +someOperation()
  #factoryMethod(): Product
}
class ConcreteCreator
Product <|.. ConcreteProduct
Creator <|-- ConcreteCreator
Creator ..> Product : usa abstraccion
ConcreteCreator ..> ConcreteProduct : crea
note right of Creator
Creator define el algoritmo general.
La subclase decide el producto concreto.
end note
@enduml
```
