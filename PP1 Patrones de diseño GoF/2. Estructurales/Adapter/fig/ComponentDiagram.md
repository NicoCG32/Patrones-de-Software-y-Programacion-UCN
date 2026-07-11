# Diagrama de componentes - Adapter

Este archivo conserva el DSL PlantUML utilizado para generar `ComponentDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Adapter - diagrama de componentes
left to right direction
skinparam componentStyle rectangle

component "Cliente" as Client
interface "Target" as Target
component "Adapter" as Adapter
component "Adaptee legado" as Adaptee

Client --> Target : invoca contrato esperado
Adapter ..|> Target
Adapter --> Adaptee : traduce y delega
@enduml
```
