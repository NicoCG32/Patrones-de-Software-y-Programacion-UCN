# Diagrama de clases - Arquitectura basada en capas

Este archivo conserva el DSL PlantUML utilizado para generar `ClassDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Arquitectura basada en capas - diagrama de clases
left to right direction
class Presentacion {
  +mostrar()
}
class AplicacionService {
  +ejecutarCasoUso()
}
class EntidadDominio {
  +validarRegla()
}
interface Repository {
  +guardar(entidad)
  +buscar(id)
}
class RepositoryImpl
Presentacion --> AplicacionService
AplicacionService --> EntidadDominio
AplicacionService --> Repository
RepositoryImpl ..|> Repository
@enduml
```
