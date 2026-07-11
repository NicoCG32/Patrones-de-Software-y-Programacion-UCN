# Diagrama de clases - Strategy

Este archivo conserva el DSL PlantUML utilizado para generar `ClassDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Strategy - clases
interface DiscountStrategy {
  +apply(price: double): double
}
class NoDiscount
class PercentageDiscount
class Cart {
  -strategy: DiscountStrategy
  +setStrategy(strategy)
  +total(price): double
}
DiscountStrategy <|.. NoDiscount
DiscountStrategy <|.. PercentageDiscount
Cart --> DiscountStrategy : delega algoritmo
@enduml
```
