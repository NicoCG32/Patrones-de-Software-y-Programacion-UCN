# Diagrama de componentes - Arquitectura de tres capas

Este archivo conserva el DSL PlantUML utilizado para generar `ComponentDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Tres capas - diagrama de componentes
left to right direction
skinparam componentStyle rectangle

component "Vista" as View
component "Servicio" as Service
component "Persistencia" as Persistence
database "Base de datos" as Database

View --> Service : operaciones del usuario
Service --> Persistence : contratos Repository/DAO
Persistence --> Database : SQL/archivo/API de datos
@enduml
```
