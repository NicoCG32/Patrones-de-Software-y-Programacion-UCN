# Explicación Detallada - MVC con Interfaces

## Para qué sirve

MVC con interfaces hace explícitos los contratos entre modelo, vista y controlador. Su finalidad es permitir sustitución y pruebas aisladas sin depender de una interfaz concreta.

Las interfaces no constituyen una cuarta parte de MVC; son un mecanismo para expresar dependencias y variantes.

## Cómo se usa

Una organización posible define:

- `Modelo`: operaciones y consulta de estado.
- `Vista`: operaciones de presentación y lectura de entrada.
- `Controlador`: recibe ambos contratos y coordina el caso de interacción.

El arranque crea implementaciones concretas y las inyecta. Una prueba del controlador puede utilizar una vista controlada y un modelo falso. El modelo permanece ajeno a consola, Swing o HTTP.

No toda clase necesita una interfaz. Debe introducirse donde exista un límite, más de una implementación, necesidad de sustitución o contrato estable. Una interfaz idéntica a una clase sin motivo aumenta ruido.

## Por qué y cuándo se usa

Es apropiado en aplicaciones educativas, GUI y sistemas que necesitan varias presentaciones o pruebas del controlador. Permite mostrar con claridad el principio de inversión de dependencias.

## Ventajas

- Dependencias explícitas.
- Pruebas aisladas mediante dobles.
- Sustitución de vistas y modelos.
- Menor acoplamiento a frameworks.
- Contratos que documentan responsabilidades.

## Desventajas

- Mayor cantidad de tipos.
- Riesgo de interfaces prematuras.
- Un contrato demasiado amplio acopla igualmente.
- La composición inicial requiere una decisión adicional.

## Origen y evolución

El MVC original ya buscaba separar roles, pero los lenguajes y frameworks posteriores incorporaron interfaces para reforzar esa separación. La evolución hacia inversión de control e inyección de dependencias convirtió los contratos explícitos en una práctica frecuente.

Las lambdas y tipos funcionales permiten contratos más pequeños en casos simples. En sistemas mayores, las interfaces nominales conservan valor por su vocabulario y capacidad de evolución.

## Estado actual

La variante es vigente cuando los límites merecen sustitución. Su calidad se evalúa por la dirección de las dependencias y la cohesión de cada contrato, no por contar interfaces. Deben preferirse contratos pequeños orientados a necesidades del consumidor.

## Ejemplo de esta carpeta

El [README](README.md) y `src/Main.java` muestran cómo el controlador recibe abstracciones. Para verificar el diseño, sustituya una implementación sin editar el controlador.

## Relación con MVC

La [explicación general de MVC](../EXPLICACIÓN.md) presenta el origen y las variantes. Esta versión se concentra en la expresión de contratos dentro de un mismo proceso.
