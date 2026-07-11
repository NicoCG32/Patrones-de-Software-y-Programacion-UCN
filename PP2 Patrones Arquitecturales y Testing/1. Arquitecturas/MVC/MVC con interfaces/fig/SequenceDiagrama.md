# Diagrama de secuencia - MVC con interfaces

Este archivo conserva el DSL PlantUML utilizado para generar `SequenceDiagrama.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title MVC con interfaces - diagrama de secuencia
actor Usuario
participant "vista: IVista" as View
participant Controlador
participant "modelo: IModelo" as Model
Usuario -> View : evento
View -> Controlador : manejarEvento()
Controlador -> Model : actualizar()
Controlador -> Model : obtenerDatos()
Model --> Controlador : datos
Controlador -> View : mostrar(datos)
View --> Usuario : salida
@enduml
```
