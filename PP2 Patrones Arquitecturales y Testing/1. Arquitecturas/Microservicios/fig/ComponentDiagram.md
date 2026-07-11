# Diagrama de componentes - Microservicios

Este archivo conserva el DSL PlantUML utilizado para generar `ComponentDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Microservicios - diagrama de componentes
left to right direction
skinparam componentStyle rectangle

component "API Gateway" as Gateway
component "Servicio Catalogo" as Catalog
component "Servicio Pedidos" as Orders
component "Servicio Pagos" as Payments
queue "Broker/Eventos" as Broker
database "DB Catalogo" as CatalogDb
database "DB Pedidos" as OrdersDb
database "DB Pagos" as PaymentsDb

Gateway --> Catalog : API
Gateway --> Orders : API
Gateway --> Payments : API
Orders --> Broker : publica evento
Payments --> Broker : consume evento
Catalog --> CatalogDb
Orders --> OrdersDb
Payments --> PaymentsDb
@enduml
```
