# Diagrama de clases - Microservicios

Este archivo conserva el DSL PlantUML utilizado para generar `ClassDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Microservicios - diagrama de clases
left to right direction
class ApiGateway {
  +route()
}
class CatalogService {
  +consultarCatalogo()
}
class OrderService {
  +crearPedido()
}
class PaymentService {
  +pagar()
}
class EventBroker {
  +publish()
  +subscribe()
}
class ServiceDatabase
ApiGateway --> CatalogService
ApiGateway --> OrderService
ApiGateway --> PaymentService
OrderService --> EventBroker
PaymentService --> EventBroker
CatalogService --> ServiceDatabase
OrderService --> ServiceDatabase
PaymentService --> ServiceDatabase
@enduml
```
