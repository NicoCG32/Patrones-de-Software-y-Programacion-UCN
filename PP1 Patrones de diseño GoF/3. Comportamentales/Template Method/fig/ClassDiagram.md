# Diagrama de clases - Template Method

Este archivo conserva el DSL PlantUML utilizado para generar `ClassDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Template Method - clases
abstract class DataImporter {
  +importData()
  #open()
  #parse()
  #validate()
  #save()
  #close()
}
class CsvImporter
DataImporter <|-- CsvImporter
note right of DataImporter
importData() es final:
las subclases no alteran el orden.
end note
@enduml
```
