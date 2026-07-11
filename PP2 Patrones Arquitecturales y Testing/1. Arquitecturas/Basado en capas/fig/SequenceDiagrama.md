# Diagrama de secuencia - Arquitectura basada en capas

Este archivo conserva el DSL PlantUML utilizado para generar `SequenceDiagrama.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Arquitectura basada en capas - diagrama de secuencia
actor Usuario
participant Presentacion
participant "AplicacionService" as Service
participant EntidadDominio
participant Repository
database Datos
Usuario -> Presentacion : solicita accion
Presentacion -> Service : ejecutarCasoUso()
Service -> EntidadDominio : validarRegla()
Service -> Repository : guardar(entidad)
Repository -> Datos : insert/update
Datos --> Repository : ok
Repository --> Service : confirmado
Service --> Presentacion : resultado
Presentacion --> Usuario : muestra resultado
@enduml
```
