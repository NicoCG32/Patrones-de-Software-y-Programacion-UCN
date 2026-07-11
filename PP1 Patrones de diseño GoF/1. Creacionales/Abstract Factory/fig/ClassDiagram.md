# Diagrama de clases - Abstract Factory

Este archivo conserva el DSL PlantUML utilizado para generar `ClassDiagram.png`. La imagen se referencia desde `EXPLICACIÓN.md` para que el material pueda estudiarse sin abrir herramientas externas.

```plantuml
@startuml
title Abstract Factory - clases
interface WidgetFactory {
  +createButton(): Button
  +createCheckbox(): Checkbox
}
interface Button {
  +render(): String
}
interface Checkbox {
  +render(): String
}
class LightWidgetFactory
class DarkWidgetFactory
class LightButton
class DarkButton
class LightCheckbox
class DarkCheckbox
class Client
WidgetFactory <|.. LightWidgetFactory
WidgetFactory <|.. DarkWidgetFactory
Button <|.. LightButton
Button <|.. DarkButton
Checkbox <|.. LightCheckbox
Checkbox <|.. DarkCheckbox
Client --> WidgetFactory : depende de abstraccion
Client --> Button
Client --> Checkbox
LightWidgetFactory ..> LightButton : crea
LightWidgetFactory ..> LightCheckbox : crea
DarkWidgetFactory ..> DarkButton : crea
DarkWidgetFactory ..> DarkCheckbox : crea
note right of Client
No conoce LightButton ni DarkButton.
La familia se cambia sustituyendo la fabrica.
end note
@enduml
```
