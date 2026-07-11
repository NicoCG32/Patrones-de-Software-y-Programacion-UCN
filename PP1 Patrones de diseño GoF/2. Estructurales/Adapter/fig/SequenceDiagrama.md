# Diagrama de secuencia - Adapter

Este archivo conserva el DSL PlantUML utilizado para generar `SequenceDiagrama.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Adapter - interaccion
participant CheckoutService
participant "adapter: PaymentProcessor" as A
participant LegacyPaymentGateway
CheckoutService -> A : pay(2590)
A -> LegacyPaymentGateway : makePayment(25.90)
LegacyPaymentGateway --> A : ok
A --> CheckoutService : ok
@enduml
```
