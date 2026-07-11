# Diagrama de componentes - Builder

Este archivo conserva el DSL PlantUML utilizado para generar `ComponentDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Builder - diagrama de componentes
left to right direction
skinparam componentStyle rectangle

component "Cliente" as Client
component "Director" as Director
interface "Builder" as IBuilder
component "Builder concreto" as ConcreteBuilder
component "Producto" as Product

Client --> Director : solicita construccion
Director --> IBuilder : ordena pasos
ConcreteBuilder ..|> IBuilder
ConcreteBuilder --> Product : ensambla
Client --> Product : recibe resultado
@enduml
```
