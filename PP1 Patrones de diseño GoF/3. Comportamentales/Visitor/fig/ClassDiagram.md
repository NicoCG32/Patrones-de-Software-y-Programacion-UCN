# Diagrama de clases - Visitor

Este archivo conserva el DSL PlantUML utilizado para generar `ClassDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Visitor - clases
interface DocumentElement {
  +accept(visitor: Visitor)
}
class Paragraph {
  +accept(visitor)
  +text(): String
}
class Image {
  +accept(visitor)
  +path(): String
}
interface Visitor {
  +visit(paragraph: Paragraph)
  +visit(image: Image)
}
class PlainTextExportVisitor
DocumentElement <|.. Paragraph
DocumentElement <|.. Image
Visitor <|.. PlainTextExportVisitor
Paragraph ..> Visitor : accept llama visit(this)
Image ..> Visitor : accept llama visit(this)
@enduml
```
