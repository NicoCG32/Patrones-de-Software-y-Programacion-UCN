# Explicación Detallada - Template Method

## Para qué sirve

Template Method define el esqueleto de un algoritmo en una operación base y permite que las subclases redefinan ciertos pasos sin alterar la secuencia general.

Separa partes **invariantes**, cuyo orden debe protegerse, de pasos **variables**, que cada especialización implementa.

## Cómo se usa

La clase abstracta contiene:

- El método plantilla, normalmente no redefinible.
- Operaciones concretas compartidas.
- Operaciones abstractas obligatorias.
- Hooks opcionales con comportamiento predeterminado.

```text
ejecutar()
  preparar()
  procesar()    <- paso variable
  finalizar()
```

El método plantilla controla el flujo. Las subclases no deberían repetirlo. Un hook permite extender un punto sin obligar a todas las variantes a intervenir.

Debe mantenerse el principio de sustitución: una subclase no puede invalidar precondiciones o romper el orden asumido por la clase base.

## Por qué se usa

Elimina duplicación de algoritmos casi idénticos y protege una secuencia obligatoria. Es apropiado cuando las variantes comparten identidad conceptual y la herencia expresa una relación válida.

## Contextos de aplicación

Se utiliza en frameworks, ciclos de pruebas, procesamiento de pedidos, importadores, compiladores y flujos con etapas comunes. Muchas APIs llaman métodos redefinidos por el usuario; esto se conoce como inversión de control.

No conviene cuando se necesitan combinar pasos libremente, cambiar comportamiento durante la ejecución o evitar una jerarquía rígida. En esos casos, Strategy o una cadena de componentes puede ser más flexible.

## Ventajas y desventajas

### Ventajas

- Reutiliza el flujo común.
- Protege el orden y las invariantes del algoritmo.
- Define puntos de extensión explícitos.
- Reduce duplicación entre variantes.

### Desventajas

- Acopla comportamiento mediante herencia.
- Los cambios en la clase base afectan a todas las subclases.
- Demasiados hooks vuelven difícil entender el flujo.
- Una subclase puede violar supuestos no documentados.

## Origen y evolución

Template Method fue catalogado por GoF en 1994 y refleja una técnica central de los frameworks orientados a objetos: el framework posee el control y la aplicación completa pasos específicos.

Con el avance de la composición, muchos diseños sustituyeron subclases por estrategias o funciones inyectadas. Aun así, el patrón sigue siendo adecuado cuando existe una abstracción estable y el algoritmo necesita proteger una secuencia común.

## Estado actual

Se mantiene vigente en frameworks y clases base cuidadosamente diseñadas. La práctica moderna limita la profundidad de herencia, documenta los hooks y prefiere métodos plantilla pequeños. La herencia debe representar una relación semántica, no solo reutilización de código.

## Patrones relacionados

- **Strategy** encapsula el algoritmo completo mediante composición.
- **Factory Method** suele actuar como un paso redefinible dentro de una plantilla.
- **Chain of Responsibility** distribuye etapas entre objetos independientes.
- **Hook Method** es un punto opcional de extensión dentro de la plantilla.

## Material de esta carpeta

El [README](README.md) y los ejemplos de pruebas y pedidos muestran qué pasos son invariantes y cuáles redefinen las subclases. Esa distinción debe identificarse antes de leer los detalles de código.

## Referencia principal

Gamma, E., Helm, R., Johnson, R. y Vlissides, J. (1994). *Design Patterns: Elements of Reusable Object-Oriented Software*. Addison-Wesley.
