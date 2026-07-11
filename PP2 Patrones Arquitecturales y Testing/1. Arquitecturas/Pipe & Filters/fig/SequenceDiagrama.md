# Diagrama de secuencia - Pipe & Filters

Este archivo conserva el DSL PlantUML utilizado para generar `SequenceDiagrama.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Pipe and Filters - diagrama de secuencia
participant Source
participant NormalizeFilter
participant TransformFilter
participant ValidateFilter
participant Sink
Source -> NormalizeFilter : datos crudos
NormalizeFilter -> TransformFilter : datos normalizados
TransformFilter -> ValidateFilter : datos transformados
ValidateFilter -> Sink : datos validos
Sink --> Source : procesamiento completo
@enduml
```
