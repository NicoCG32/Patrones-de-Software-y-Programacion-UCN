# Diagrama de componentes - Facade

Este archivo conserva el DSL PlantUML utilizado para generar `ComponentDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Facade - diagrama de componentes
left to right direction
skinparam componentStyle rectangle

component "Cliente" as Client
component "Facade" as Facade
component "Subsistema" as Subsystem {
  component "Inventario" as Inventory
  component "Pago" as Payment
  component "Envio" as Shipping
}

Client --> Facade : operacion simple
Facade --> Inventory : coordina
Facade --> Payment : coordina
Facade --> Shipping : coordina
@enduml
```
