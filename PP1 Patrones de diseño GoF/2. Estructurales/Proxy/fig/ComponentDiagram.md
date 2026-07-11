# Diagrama de componentes - Proxy

Este archivo conserva el DSL PlantUML utilizado para generar `ComponentDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Proxy - diagrama de componentes
left to right direction
skinparam componentStyle rectangle

component "Cliente" as Client
interface "Subject" as Subject
component "Proxy" as Proxy
component "RealSubject" as RealSubject
component "Politica de acceso/cache" as Policy

Client --> Subject : request()
Proxy ..|> Subject
RealSubject ..|> Subject
Proxy --> Policy : valida o cachea
Proxy --> RealSubject : delega cuando corresponde
@enduml
```
