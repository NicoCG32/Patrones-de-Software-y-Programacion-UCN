# Diagrama de componentes - Arquitectura de N capas

Este archivo conserva el DSL PlantUML utilizado para generar `ComponentDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title N capas lineales - diagrama de componentes
left to right direction
skinparam componentStyle rectangle

component "Capa 1\nInterfaz" as Layer1
component "Capa 2\nAplicacion" as Layer2
component "Capa 3\nDominio" as Layer3
component "Capa 4\nIntegracion" as Layer4
component "Capa N\nRecurso externo" as LayerN

Layer1 --> Layer2
Layer2 --> Layer3
Layer3 --> Layer4
Layer4 --> LayerN
note bottom of Layer3
Cada nueva capa debe aportar
una responsabilidad estable.
end note
@enduml
```
