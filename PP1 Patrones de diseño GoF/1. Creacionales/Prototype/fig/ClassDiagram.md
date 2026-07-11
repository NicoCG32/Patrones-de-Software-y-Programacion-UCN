# Diagrama de clases - Prototype

Este archivo conserva el DSL PlantUML utilizado para generar `ClassDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Prototype - clases
interface Prototype<T> {
  +copy(): T
}
class QueryTemplate {
  -table: String
  -filter: String
  +copy(): QueryTemplate
  +withFilter(filter): QueryTemplate
}
class Client
Prototype <|.. QueryTemplate
Client --> Prototype : clona
@enduml
```
