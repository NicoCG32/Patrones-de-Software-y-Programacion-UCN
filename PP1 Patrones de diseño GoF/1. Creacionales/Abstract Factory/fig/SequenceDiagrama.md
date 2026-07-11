# Diagrama de secuencia - Abstract Factory

Este archivo conserva el DSL PlantUML utilizado para generar `SequenceDiagrama.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Abstract Factory - interaccion
actor Usuario
participant Client
participant "factory: WidgetFactory" as F
participant Button
participant Checkbox
Usuario -> Client : start(factory)
Client -> F : createButton()
F --> Client : Button
Client -> F : createCheckbox()
F --> Client : Checkbox
Client -> Button : render()
Client -> Checkbox : render()
@enduml
```
