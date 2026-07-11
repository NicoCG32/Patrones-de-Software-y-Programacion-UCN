# Diagrama de componentes - Template Method

Este archivo conserva el DSL PlantUML utilizado para generar `ComponentDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Template Method - diagrama de componentes
left to right direction
skinparam componentStyle rectangle

component "Cliente" as Client
component "Clase abstracta" as AbstractClass
component "Subclase concreta" as ConcreteClass
component "Operacion plantilla" as TemplateOperation
component "Pasos variables" as VariableSteps

Client --> AbstractClass : ejecuta templateMethod()
ConcreteClass -up-|> AbstractClass
AbstractClass --> TemplateOperation : define orden fijo
ConcreteClass --> VariableSteps : implementa hooks/pasos
TemplateOperation --> VariableSteps : invoca pasos
@enduml
```
