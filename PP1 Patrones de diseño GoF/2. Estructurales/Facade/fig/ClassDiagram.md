# Diagrama de clases - Facade

Este archivo conserva el DSL PlantUML utilizado para generar `ClassDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Facade - clases
class OrderFacade {
  +placeOrder(sku, account)
}
class Inventory {
  +hasStock(sku): boolean
}
class Payment {
  +charge(account)
}
class Shipping {
  +schedule(sku)
}
class Client
Client --> OrderFacade : usa API simple
OrderFacade --> Inventory
OrderFacade --> Payment
OrderFacade --> Shipping
@enduml
```
