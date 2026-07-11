# Diagrama de secuencia - Facade

Este archivo conserva el DSL PlantUML utilizado para generar `SequenceDiagrama.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Facade - interaccion
participant Client
participant OrderFacade
participant Inventory
participant Payment
participant Shipping
Client -> OrderFacade : placeOrder(sku, account)
OrderFacade -> Inventory : hasStock(sku)
Inventory --> OrderFacade : true
OrderFacade -> Payment : charge(account)
OrderFacade -> Shipping : schedule(sku)
OrderFacade --> Client : orden aceptada
@enduml
```
