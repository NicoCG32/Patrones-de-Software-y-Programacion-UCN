# Diagrama de clases - Arquitectura de tres capas

Este archivo conserva el DSL PlantUML utilizado para generar `ClassDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Tres capas - diagrama de clases
left to right direction
class Vista {
  +mostrar()
  +leerEntrada()
}
class PedidoService {
  +registrarPedido()
}
interface PedidoRepository {
  +guardar(pedido)
  +buscar(id)
}
class PedidoRepositorySql
class Pedido
Vista --> PedidoService
PedidoService --> Pedido
PedidoService --> PedidoRepository
PedidoRepositorySql ..|> PedidoRepository
@enduml
```
