# Diagrama de clases - Observer

Este archivo conserva el DSL PlantUML utilizado para generar `ClassDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Observer - clases
interface Observer {
  +update(newState: String)
}
class Subject {
  -observers: List<Observer>
  -state: String
  +attach(observer)
  +detach(observer)
  +setState(state)
}
class ConsoleObserver
Observer <|.. ConsoleObserver
Subject o-- Observer : suscritos
@enduml
```
