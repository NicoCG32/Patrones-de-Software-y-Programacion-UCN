# Diagrama de clases - Arquitectura de N capas

Este archivo conserva el DSL PlantUML utilizado para generar `ClassDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title N capas lineales - diagrama de clases
left to right direction
class CapaInterfaz {
  +recibir()
}
class CapaAplicacion {
  +coordinar()
}
class CapaDominio {
  +resolverRegla()
}
class CapaIntegracion {
  +adaptar()
}
class RecursoExterno {
  +operacion()
}
CapaInterfaz --> CapaAplicacion
CapaAplicacion --> CapaDominio
CapaDominio --> CapaIntegracion
CapaIntegracion --> RecursoExterno
@enduml
```
