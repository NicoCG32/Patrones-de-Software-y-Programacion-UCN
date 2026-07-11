# Diagrama de secuencia - MVC

Este archivo conserva el DSL PlantUML utilizado para generar `SequenceDiagrama.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title MVC - diagrama de secuencia
actor Usuario
participant View
participant Controller
participant Model
Usuario -> View : evento de interfaz
View -> Controller : handle(evento)
Controller -> Model : actualizar(comando)
Model -> Model : cambia estado
Model --> View : notifica cambio
View -> Model : consultarEstado()
Model --> View : estado
View --> Usuario : renderiza
@enduml
```
