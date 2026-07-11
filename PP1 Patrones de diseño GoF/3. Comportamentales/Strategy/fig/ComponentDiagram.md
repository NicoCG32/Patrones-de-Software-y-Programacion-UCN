# Diagrama de componentes - Strategy

Este archivo conserva el DSL PlantUML utilizado para generar `ComponentDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Strategy - diagrama de componentes
left to right direction
skinparam componentStyle rectangle

component "Cliente" as Client
component "Context" as Context
interface "Strategy" as IStrategy
component "Estrategia A" as StrategyA
component "Estrategia B" as StrategyB

Client --> Context : configura estrategia
Context --> IStrategy : delega algoritmo
StrategyA ..|> IStrategy
StrategyB ..|> IStrategy
@enduml
```
