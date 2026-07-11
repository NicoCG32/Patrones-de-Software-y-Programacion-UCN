# Diagrama de componentes - Arquitectura basada en capas

Este archivo conserva el DSL PlantUML utilizado para generar `ComponentDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Arquitectura basada en capas - diagrama de componentes
left to right direction
skinparam componentStyle rectangle

component "Presentacion" as Presentation
component "Aplicacion / Service" as Service
component "Dominio" as Domain
component "Persistencia / Repository" as Repository
database "Datos" as Database

Presentation --> Service : casos de uso
Service --> Domain : reglas de negocio
Service --> Repository : solicita persistencia
Repository --> Database : lee/escribe
@enduml
```
