# Explicación Detallada - Decorator

## Para qué sirve

Decorator agrega responsabilidades a un objeto de manera dinámica mediante composición, conservando su interfaz. Permite combinar comportamientos sin crear una subclase por cada combinación posible.

La idea central es envolver un componente con otro objeto que implementa el mismo contrato. El decorador realiza trabajo antes o después de delegar.

## Cómo se usa

Participan:

- **Component**: contrato común.
- **ConcreteComponent**: comportamiento base.
- **Decorator**: mantiene una referencia a otro `Component`.
- **ConcreteDecorator**: agrega una responsabilidad específica.

```text
cliente -> decorador A -> decorador B -> componente base
```

El orden puede ser significativo. Comprimir y luego cifrar no siempre equivale a cifrar y luego comprimir. Por ello la composición debe documentar sus precondiciones y efectos.

Un decorador debe ser sustituible por el componente. Si cambia radicalmente el contrato, exige métodos externos o impide operaciones válidas, probablemente corresponde otra abstracción.

## Por qué se usa

Evita la explosión combinatoria de subclases. Con tres características opcionales, la herencia puede necesitar clases para numerosas combinaciones; Decorator permite construirlas mediante envoltorios independientes.

## Contextos de aplicación

Es común en flujos de entrada y salida, middleware, validación, caché, métricas, autorización, cálculo de precios y presentación. Funciona mejor cuando las responsabilidades son ortogonales y pueden expresarse con el mismo contrato.

No conviene cuando el orden genera demasiadas combinaciones difíciles de razonar, cuando el cliente necesita identificar el componente concreto o cuando una operación transversal se implementa mejor en infraestructura.

## Ventajas y desventajas

### Ventajas

- Agrega comportamiento sin modificar la clase base.
- Permite combinaciones en tiempo de ejecución.
- Favorece clases pequeñas y con una responsabilidad.
- Reduce jerarquías de herencia.

### Desventajas

- Produce cadenas de objetos pequeños.
- El orden de composición puede ser sutil.
- La depuración muestra varias capas de delegación.
- Comparar identidad o tipo concreto se vuelve frágil.
- Decoradores con demasiada configuración pierden independencia.

## Origen y evolución

Decorator fue descrito por GoF en 1994 y se relaciona con la composición usada en sistemas gráficos y flujos. Java popularizó una forma reconocible mediante las clases de `java.io`, donde varios streams agregan buffering, transformación u otras capacidades.

El principio evolucionó hacia pipelines de middleware, filtros web e interceptores. No todos son Decorator en sentido estricto, pero comparten la composición de responsabilidades alrededor de una operación central.

## Estado actual

El patrón continúa vigente, especialmente para comportamiento transversal local. Las anotaciones, proxies dinámicos y programación orientada a aspectos automatizan algunos envoltorios, aunque pueden hacer menos visible la cadena. Un Decorator explícito suele ser preferible cuando el orden y las dependencias forman parte del diseño.

## Patrones relacionados

- **Proxy** controla acceso y suele representar al mismo sujeto.
- **Adapter** cambia la interfaz esperada.
- **Composite** organiza componentes en árboles; Decorator forma cadenas de envoltura.
- **Chain of Responsibility** permite que varios manejadores decidan si procesan o continúan.

## Material de esta carpeta

El [README](README.md) y los ejemplos de flujos y precios muestran composición acumulativa. Conviene ejecutar distintas órdenes de decoradores y comparar el resultado.

## Referencia principal

Gamma, E., Helm, R., Johnson, R. y Vlissides, J. (1994). *Design Patterns: Elements of Reusable Object-Oriented Software*. Addison-Wesley.
