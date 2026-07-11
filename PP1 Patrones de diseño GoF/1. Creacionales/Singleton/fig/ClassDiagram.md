# Diagrama de clases - Singleton

Este archivo conserva el DSL PlantUML utilizado para generar `ClassDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Singleton - clases
class Configuration {
  -INSTANCE: Configuration
  -environment: String
  -Configuration()
  +getInstance(): Configuration
  +environment(): String
}
class Client
Client --> Configuration : getInstance()
note right of Configuration
Constructor privado.
La instancia se crea una sola vez.
end note
@enduml
```
