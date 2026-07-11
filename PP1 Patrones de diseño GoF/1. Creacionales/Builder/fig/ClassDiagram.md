# Diagrama de clases - Builder

Este archivo conserva el DSL PlantUML utilizado para generar `ClassDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Builder - clases
interface ReportBuilder {
  +buildTitle()
  +buildBody()
  +buildFooter()
  +getResult(): Report
}
class ExecutiveReportBuilder
class Director {
  +construct(builder): Report
}
class Report
ReportBuilder <|.. ExecutiveReportBuilder
Director --> ReportBuilder : ordena pasos
ExecutiveReportBuilder --> Report : ensambla
note right of Director
Controla el algoritmo.
No conoce la representacion interna.
end note
@enduml
```
