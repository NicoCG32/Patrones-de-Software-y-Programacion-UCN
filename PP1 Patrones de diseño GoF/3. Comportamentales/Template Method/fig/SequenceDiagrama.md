# Diagrama de secuencia - Template Method

Este archivo conserva el DSL PlantUML utilizado para generar `SequenceDiagrama.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Template Method - interaccion
participant Client
participant CsvImporter
Client -> CsvImporter : importData()
CsvImporter -> CsvImporter : open()
CsvImporter -> CsvImporter : parse()
CsvImporter -> CsvImporter : validate()
CsvImporter -> CsvImporter : save()
CsvImporter -> CsvImporter : close()
@enduml
```
