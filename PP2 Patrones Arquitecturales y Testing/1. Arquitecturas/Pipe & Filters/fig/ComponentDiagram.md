# Diagrama de componentes - Pipe & Filters

Este archivo conserva el DSL PlantUML utilizado para generar `ComponentDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Pipe and Filters - diagrama de componentes
left to right direction
skinparam componentStyle rectangle

component "Fuente" as Source
component "Filtro 1\nNormalizar" as Filter1
component "Filtro 2\nTransformar" as Filter2
component "Filtro 3\nValidar" as Filter3
component "Destino" as Sink

Source --> Filter1 : pipe
Filter1 --> Filter2 : pipe
Filter2 --> Filter3 : pipe
Filter3 --> Sink : pipe
note bottom of Filter2
Cada filtro transforma datos
sin conocer toda la tuberia.
end note
@enduml
```
