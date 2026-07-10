# Explicación Detallada - Modelo-Vista-Controlador

## Para qué sirve

Modelo-Vista-Controlador (MVC) separa el estado y las reglas, su representación y la interpretación de acciones del usuario. Su propósito original es permitir múltiples formas de observar y manipular un modelo sin mezclar dominio e interfaz.

MVC no es una distribución en tres capas equivalentes. Sus componentes colaboran alrededor de la interacción:

- **Modelo**: representa información, reglas y operaciones significativas.
- **Vista**: presenta una representación del modelo.
- **Controlador**: interpreta entradas y coordina acciones sobre el modelo o la vista.

## Cómo se usa

El flujo depende de la variante:

1. El usuario actúa sobre la interfaz.
2. El controlador interpreta la entrada.
3. El modelo ejecuta una operación y cambia de estado.
4. La vista obtiene o recibe el nuevo estado.
5. La vista presenta el resultado.

En MVC de escritorio, la vista puede observar al modelo. En MVC web del lado del servidor, el controlador procesa una solicitud, consulta un modelo y selecciona una vista para construir una respuesta. Ambos se denominan MVC, pero su ciclo y estado son distintos.

Los contratos deben evitar que el modelo dependa de widgets, HTTP o consola. La vista tampoco debería contener reglas de negocio solo porque posee los datos ingresados.

## Por qué se usa

Permite cambiar presentación e interacción conservando el modelo. Hace posible probar reglas sin levantar una interfaz y reutilizar un modelo en distintas vistas.

## Contextos de aplicación

Se usa en interfaces gráficas, aplicaciones de consola estructuradas y frameworks web. Resulta útil cuando la interacción es suficientemente compleja para justificar roles separados o cuando existen varias representaciones.

No conviene imponerlo a programas mínimos sin estado significativo. Tampoco resuelve por sí solo persistencia, servicios distribuidos o límites de módulos.

## Ventajas y desventajas

### Ventajas

- Separa modelo, presentación y entrada.
- Facilita múltiples vistas del mismo estado.
- Permite probar modelo y controlador de forma aislada.
- Reduce dependencia del dominio hacia la tecnología de interfaz.

### Desventajas

- Existen numerosas interpretaciones incompatibles del patrón.
- El controlador puede acumular lógica.
- La sincronización modelo-vista puede ser compleja.
- En GUI dirigida por eventos, el flujo resulta difícil de rastrear.
- Puede confundirse con arquitectura en tres capas.

## Origen y evolución

Trygve Reenskaug formuló MVC durante su trabajo con Smalltalk en Xerox PARC entre 1978 y 1979. El problema era permitir que una persona controlara y observara información compleja desde distintas perspectivas. Smalltalk-80 consolidó la triada y la relación con observación.

En aplicaciones de escritorio surgieron variantes como Model-View-Presenter y Model-View-ViewModel para controlar mejor la lógica de presentación y el enlace de datos. En la web, frameworks del lado del servidor reutilizaron el nombre MVC para un ciclo solicitud-respuesta: rutas y controladores coordinan modelos y plantillas. En el cliente aparecieron arquitecturas de componentes y flujo unidireccional.

## Estado actual

MVC continúa vigente, pero debe definirse la variante concreta antes de evaluarlo. En sistemas web modernos, “modelo” puede significar entidad de dominio, DTO o modelo de vista; esa ambigüedad debe resolverse en la documentación.

La calidad depende de mantener las reglas fuera de la vista y los detalles de interfaz fuera del modelo, no de nombrar tres carpetas.

## Variantes de esta carpeta

- [MVC con interfaces](<MVC con interfaces/EXPLICACIÓN.md>).
- [MVC para CLI](<MVC CLI/EXPLICACIÓN.md>).
- [MVC Web](<MVC Web/EXPLICACIÓN.md>).

El [README](README.md) resume los ejemplos ejecutables.

## Referencias

- Reenskaug, T. (1979). *The Original MVC Reports*.
- [Archivo histórico de MVC de Trygve Reenskaug](https://folk.universitetetioslo.no/trygver/themes/mvc/mvc-index.html).
