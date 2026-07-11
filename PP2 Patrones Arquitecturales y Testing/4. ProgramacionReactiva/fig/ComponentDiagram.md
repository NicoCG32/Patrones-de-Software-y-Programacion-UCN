# Diagrama de componentes - Programacion reactiva

Este archivo conserva el DSL PlantUML utilizado para generar `ComponentDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Programacion reactiva - diagrama de componentes
left to right direction
skinparam componentStyle rectangle

component "Productor" as Producer
queue "Event Bus" as Bus
component "Consumidor A" as ConsumerA
component "Consumidor B" as ConsumerB
component "Servicio request-response" as Service
component "Callback/Future" as Future

Producer --> Bus : publish(evento)
Bus --> ConsumerA : notifica
Bus --> ConsumerB : notifica
Producer --> Service : request(mensaje)
Service --> Future : responde asincronamente
Future --> Producer : callback/resultado
@enduml
```
