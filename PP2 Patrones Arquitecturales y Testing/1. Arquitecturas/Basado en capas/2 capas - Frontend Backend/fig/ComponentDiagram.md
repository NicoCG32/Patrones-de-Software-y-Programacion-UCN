# Diagrama de componentes - Arquitectura de dos capas

Este archivo conserva el DSL PlantUML utilizado para generar `ComponentDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Dos capas - diagrama de componentes
left to right direction
skinparam componentStyle rectangle

component "Frontend" as Frontend
component "Backend" as Backend
database "Datos" as Database

Frontend --> Backend : solicitudes HTTP/API
Backend --> Database : consulta y persiste
note bottom of Backend
La segunda capa concentra API,
reglas y acceso a datos.
end note
@enduml
```
