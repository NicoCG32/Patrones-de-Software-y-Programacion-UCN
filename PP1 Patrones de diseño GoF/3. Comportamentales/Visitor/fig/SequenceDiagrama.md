# Diagrama de secuencia - Visitor

Este archivo conserva el DSL PlantUML utilizado para generar `SequenceDiagrama.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Visitor - interaccion
participant Client
participant Paragraph
participant PlainTextExportVisitor
Client -> Paragraph : accept(visitor)
Paragraph -> PlainTextExportVisitor : visit(this)
PlainTextExportVisitor --> Client : operacion aplicada
@enduml
```
