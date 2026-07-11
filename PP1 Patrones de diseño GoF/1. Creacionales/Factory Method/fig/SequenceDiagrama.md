# Diagrama de secuencia - Factory Method

Este archivo conserva el DSL PlantUML utilizado para generar `SequenceDiagrama.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Factory Method - interaccion
participant Client
participant "creator: Creator" as C
participant "product: Product" as P
Client -> C : someOperation()
C -> C : factoryMethod()
C --> C : ConcreteProduct como Product
C -> P : operation()
P --> C : resultado
C --> Client : resultado final
@enduml
```
