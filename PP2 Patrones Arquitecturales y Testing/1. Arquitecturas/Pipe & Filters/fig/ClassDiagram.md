# Diagrama de clases - Pipe & Filters

Este archivo conserva el DSL PlantUML utilizado para generar `ClassDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Pipe and Filters - diagrama de clases
left to right direction
interface Filter {
  +process(input)
}
class Source {
  +read()
}
class NormalizeFilter
class TransformFilter
class ValidateFilter
class Sink {
  +write(output)
}
NormalizeFilter ..|> Filter
TransformFilter ..|> Filter
ValidateFilter ..|> Filter
Source --> Filter
Filter --> Sink
@enduml
```
