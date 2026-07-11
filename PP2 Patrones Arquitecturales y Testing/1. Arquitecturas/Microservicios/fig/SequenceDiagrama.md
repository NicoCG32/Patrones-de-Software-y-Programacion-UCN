# Diagrama de secuencia - Microservicios

Este archivo conserva el DSL PlantUML utilizado para generar `SequenceDiagrama.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Microservicios - diagrama de secuencia
actor Cliente
participant ApiGateway
participant OrderService
participant EventBroker
participant PaymentService
Cliente -> ApiGateway : crear pedido
ApiGateway -> OrderService : POST /orders
OrderService -> EventBroker : publish(OrderCreated)
EventBroker -> PaymentService : consume evento
PaymentService -> EventBroker : publish(PaymentProcessed)
EventBroker -> OrderService : consume resultado
OrderService --> ApiGateway : estado pedido
ApiGateway --> Cliente : respuesta
@enduml
```
