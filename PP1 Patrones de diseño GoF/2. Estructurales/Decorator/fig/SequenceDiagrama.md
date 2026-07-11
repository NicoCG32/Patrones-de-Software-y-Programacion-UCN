# Diagrama de secuencia - Decorator

Este archivo conserva el DSL PlantUML utilizado para generar `SequenceDiagrama.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Decorator - interaccion
participant Client
participant SignedMessage
participant EncryptedMessage
participant PlainMessage
Client -> SignedMessage : content()
SignedMessage -> EncryptedMessage : content()
EncryptedMessage -> PlainMessage : content()
PlainMessage --> EncryptedMessage : datos
EncryptedMessage --> SignedMessage : encrypt(datos)
SignedMessage --> Client : sign(encrypt(datos))
@enduml
```
