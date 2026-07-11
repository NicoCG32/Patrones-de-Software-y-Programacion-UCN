# Diagrama de secuencia - Observer

Este archivo conserva el DSL PlantUML utilizado para generar `SequenceDiagrama.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Observer - interaccion
participant Client
participant Subject
participant ConsoleObserver
Client -> Subject : attach(observer)
Client -> Subject : setState("actualizado")
Subject -> ConsoleObserver : update("actualizado")
@enduml
```
