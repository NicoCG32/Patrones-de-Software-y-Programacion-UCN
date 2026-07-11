# Diagrama de clases - Adapter

Este archivo conserva el DSL PlantUML utilizado para generar `ClassDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Adapter - clases
interface PaymentProcessor {
  +pay(cents: int)
}
class PaymentGatewayAdapter {
  -gateway: LegacyPaymentGateway
  +pay(cents: int)
}
class LegacyPaymentGateway {
  +makePayment(amount: double)
}
class CheckoutService
PaymentProcessor <|.. PaymentGatewayAdapter
PaymentGatewayAdapter --> LegacyPaymentGateway : traduce y delega
CheckoutService --> PaymentProcessor : usa interfaz objetivo
@enduml
```
