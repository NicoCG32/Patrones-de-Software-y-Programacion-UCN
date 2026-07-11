# Diagrama de clases - Programacion reactiva

Este archivo conserva el DSL PlantUML utilizado para generar `ClassDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Programacion reactiva - diagrama de clases
left to right direction
class Publisher {
  +publish(evento)
}
class EventBus {
  +send()
  +publish()
  +subscribe()
}
class Subscriber {
  +handle(evento)
}
class Requester {
  +request()
}
class ReactiveService {
  +handle(mensaje)
}
class FutureResult {
  +onComplete(callback)
}
Publisher --> EventBus
EventBus --> Subscriber
Requester --> ReactiveService
ReactiveService --> FutureResult
FutureResult --> Requester
@enduml
```
