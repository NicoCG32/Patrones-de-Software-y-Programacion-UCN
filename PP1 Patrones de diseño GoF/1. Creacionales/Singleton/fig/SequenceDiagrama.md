# Diagrama de secuencia - Singleton

Este archivo conserva el DSL PlantUML utilizado para generar `SequenceDiagrama.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Singleton - interaccion
participant ClientA
participant ClientB
participant Configuration
ClientA -> Configuration : getInstance()
Configuration --> ClientA : INSTANCE
ClientB -> Configuration : getInstance()
Configuration --> ClientB : misma INSTANCE
@enduml
```
