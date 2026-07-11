# Diagrama de secuencia - Arquitectura hexagonal

Este archivo conserva el DSL PlantUML utilizado para generar `SequenceDiagrama.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Arquitectura hexagonal - diagrama de secuencia
actor Usuario
participant PrimaryAdapter
participant "InputPort" as Input
participant UseCase
participant "OutputPort" as Output
participant SecondaryAdapter
Usuario -> PrimaryAdapter : solicita caso de uso
PrimaryAdapter -> Input : ejecutar(comando)
Input -> UseCase : delega
UseCase -> Output : guardar/obtener
Output -> SecondaryAdapter : adaptador externo
SecondaryAdapter --> Output : respuesta
Output --> UseCase : datos
UseCase --> PrimaryAdapter : resultado
PrimaryAdapter --> Usuario : respuesta
@enduml
```
