# Diagrama de componentes - Arquitectura hexagonal

Este archivo conserva el DSL PlantUML utilizado para generar `ComponentDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Arquitectura hexagonal - diagrama de componentes
left to right direction
skinparam componentStyle rectangle

component "Adaptador primario\nCLI/REST/UI" as PrimaryAdapter
interface "Puerto de entrada" as InputPort
component "Nucleo de aplicacion" as Core
interface "Puerto de salida" as OutputPort
component "Adaptador secundario\nDB/API/Correo" as SecondaryAdapter
component "Recurso externo" as External

PrimaryAdapter --> InputPort : invoca caso de uso
InputPort --> Core : contrato interno
Core --> OutputPort : requiere capacidad externa
SecondaryAdapter ..|> OutputPort
SecondaryAdapter --> External : integra tecnologia
@enduml
```
