# Diagrama de clases - Decorator

Este archivo conserva el DSL PlantUML utilizado para generar `ClassDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Decorator - clases
interface Message {
  +content(): String
}
class PlainMessage
abstract class MessageDecorator {
  -wrapped: Message
  +content(): String
}
class EncryptedMessage
class SignedMessage
Message <|.. PlainMessage
Message <|.. MessageDecorator
MessageDecorator <|-- EncryptedMessage
MessageDecorator <|-- SignedMessage
MessageDecorator --> Message : envuelve
@enduml
```
