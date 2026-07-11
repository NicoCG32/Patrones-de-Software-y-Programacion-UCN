# Diagrama de secuencia - Arquitectura de dos capas

Este archivo conserva el DSL PlantUML utilizado para generar `SequenceDiagrama.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Dos capas - diagrama de secuencia
actor Usuario
participant Frontend
participant Backend
database Datos
Usuario -> Frontend : interactua
Frontend -> Backend : request API
Backend -> Datos : consulta/persistencia
Datos --> Backend : datos
Backend --> Frontend : response
Frontend --> Usuario : renderiza estado
@enduml
```
