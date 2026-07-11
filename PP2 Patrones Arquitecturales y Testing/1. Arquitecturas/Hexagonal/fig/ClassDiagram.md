# Diagrama de clases - Arquitectura hexagonal

Este archivo conserva el DSL PlantUML utilizado para generar `ClassDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Arquitectura hexagonal - diagrama de clases
left to right direction
interface InputPort {
  +ejecutar(comando)
}
class UseCase
interface OutputPort {
  +guardar()
  +obtener()
}
class PrimaryAdapter
class SecondaryAdapter
class DomainEntity
PrimaryAdapter --> InputPort
UseCase ..|> InputPort
UseCase --> DomainEntity
UseCase --> OutputPort
SecondaryAdapter ..|> OutputPort
@enduml
```
