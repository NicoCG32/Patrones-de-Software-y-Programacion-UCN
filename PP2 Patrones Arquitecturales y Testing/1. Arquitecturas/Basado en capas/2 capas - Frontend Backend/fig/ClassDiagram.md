# Diagrama de clases - Arquitectura de dos capas

Este archivo conserva el DSL PlantUML utilizado para generar `ClassDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Dos capas - diagrama de clases
left to right direction
class FrontendView {
  +capturarEvento()
  +renderizar()
}
class ApiClient {
  +request()
}
class BackendController {
  +handle()
}
class BackendService {
  +procesar()
}
class DataRepository {
  +consultar()
}
FrontendView --> ApiClient
ApiClient --> BackendController
BackendController --> BackendService
BackendService --> DataRepository
@enduml
```
