# Diagrama de secuencia - Prototype

Este archivo conserva el DSL PlantUML utilizado para generar `SequenceDiagrama.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Prototype - interaccion
participant Client
participant "base: QueryTemplate" as Base
participant "copy: QueryTemplate" as Copy
Client -> Base : copy()
Base --> Client : Copy
Client -> Copy : withFilter("status=CLOSED")
Copy --> Client : variante
@enduml
```
