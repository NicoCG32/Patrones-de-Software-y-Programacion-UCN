# Diagrama de clases - Proxy

Este archivo conserva el DSL PlantUML utilizado para generar `ClassDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Proxy - clases
interface Image {
  +display()
}
class HighResolutionImage
class LazyImageProxy {
  -path: String
  -realImage: HighResolutionImage
  +display()
}
class Client
Image <|.. HighResolutionImage
Image <|.. LazyImageProxy
LazyImageProxy --> HighResolutionImage : crea bajo demanda
Client --> Image
@enduml
```
