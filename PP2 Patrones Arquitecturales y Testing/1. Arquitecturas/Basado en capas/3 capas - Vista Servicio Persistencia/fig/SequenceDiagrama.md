# Diagrama de secuencia - Arquitectura de tres capas

Este archivo conserva el DSL PlantUML utilizado para generar `SequenceDiagrama.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Tres capas - diagrama de secuencia
actor Usuario
participant Vista
participant PedidoService
participant PedidoRepository
database BaseDatos
Usuario -> Vista : registra pedido
Vista -> PedidoService : registrarPedido(datos)
PedidoService -> PedidoService : validar reglas
PedidoService -> PedidoRepository : guardar(pedido)
PedidoRepository -> BaseDatos : insert
BaseDatos --> PedidoRepository : ok
PedidoRepository --> PedidoService : confirmado
PedidoService --> Vista : resultado
Vista --> Usuario : confirma
@enduml
```
