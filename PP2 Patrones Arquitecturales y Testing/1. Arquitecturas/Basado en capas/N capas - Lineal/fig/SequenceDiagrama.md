# Diagrama de secuencia - Arquitectura de N capas

Este archivo conserva el DSL PlantUML utilizado para generar `SequenceDiagrama.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title N capas lineales - diagrama de secuencia
actor Usuario
participant CapaInterfaz
participant CapaAplicacion
participant CapaDominio
participant CapaIntegracion
participant RecursoExterno
Usuario -> CapaInterfaz : accion
CapaInterfaz -> CapaAplicacion : solicitud
CapaAplicacion -> CapaDominio : regla
CapaDominio -> CapaIntegracion : requiere recurso
CapaIntegracion -> RecursoExterno : operacion
RecursoExterno --> CapaIntegracion : respuesta
CapaIntegracion --> CapaDominio : datos
CapaDominio --> CapaAplicacion : resultado
CapaAplicacion --> CapaInterfaz : respuesta
CapaInterfaz --> Usuario : salida
@enduml
```
