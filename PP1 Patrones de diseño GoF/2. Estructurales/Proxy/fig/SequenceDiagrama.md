# Diagrama de secuencia - Proxy

Este archivo conserva el DSL PlantUML utilizado para generar `SequenceDiagrama.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Proxy - interaccion
participant Client
participant LazyImageProxy
participant HighResolutionImage
Client -> LazyImageProxy : display()
LazyImageProxy -> HighResolutionImage : new(path)
LazyImageProxy -> HighResolutionImage : display()
HighResolutionImage --> Client : imagen mostrada
@enduml
```
