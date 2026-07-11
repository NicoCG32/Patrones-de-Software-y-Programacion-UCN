# Diagrama de secuencia - Strategy

Este archivo conserva el DSL PlantUML utilizado para generar `SequenceDiagrama.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Strategy - interaccion
participant Client
participant Cart
participant PercentageDiscount
Client -> Cart : setStrategy(PercentageDiscount)
Client -> Cart : total(100)
Cart -> PercentageDiscount : apply(100)
PercentageDiscount --> Cart : 80
Cart --> Client : 80
@enduml
```
