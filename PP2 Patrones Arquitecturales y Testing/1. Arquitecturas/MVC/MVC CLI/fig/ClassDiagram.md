# Diagrama de clases - MVC CLI

Este archivo conserva el DSL PlantUML utilizado para generar `ClassDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title MVC CLI - diagrama de clases
left to right direction
class ConsoleView {
  +leerLinea()
  +imprimir()
}
class CommandController {
  +ejecutar(comando)
}
class CliModel {
  +aplicar()
  +estado()
}
class Console
ConsoleView --> Console
ConsoleView --> CommandController
CommandController --> CliModel
ConsoleView --> CliModel : consulta estado
@enduml
```
