# Diagrama de secuencia - Programacion reactiva

Este archivo conserva el DSL PlantUML utilizado para generar `SequenceDiagrama.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Programacion reactiva - diagrama de secuencia
participant Publisher
participant EventBus
participant Subscriber
participant Requester
participant ReactiveService
Publisher -> EventBus : publish(evento)
EventBus -> Subscriber : handle(evento)
Requester -> ReactiveService : request(mensaje)
ReactiveService --> Requester : future/callback
Requester -> Requester : continua sin bloquear
@enduml
```
