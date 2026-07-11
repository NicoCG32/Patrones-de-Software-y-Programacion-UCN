# Diagrama de secuencia - MVC CLI

Este archivo conserva el DSL PlantUML utilizado para generar `SequenceDiagrama.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title MVC CLI - diagrama de secuencia
actor Usuario
participant ConsoleView
participant CommandController
participant CliModel
Usuario -> ConsoleView : escribe comando
ConsoleView -> CommandController : ejecutar(comando)
CommandController -> CliModel : aplicar()
CliModel --> CommandController : resultado
CommandController --> ConsoleView : salida
ConsoleView --> Usuario : imprime respuesta
@enduml
```
