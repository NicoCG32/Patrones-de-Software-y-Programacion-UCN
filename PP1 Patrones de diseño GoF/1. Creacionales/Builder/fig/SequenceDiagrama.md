# Diagrama de secuencia - Builder

Este archivo conserva el DSL PlantUML utilizado para generar `SequenceDiagrama.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Builder - interaccion
participant Main
participant Director
participant "builder: ReportBuilder" as B
participant Report
Main -> Director : construct(builder)
Director -> B : buildTitle()
Director -> B : buildBody()
Director -> B : buildFooter()
Director -> B : getResult()
B --> Director : Report
Director --> Main : Report
@enduml
```
