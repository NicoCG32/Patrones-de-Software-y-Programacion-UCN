# Explicación Detallada - MVC Web

## Para qué sirve

MVC Web organiza el procesamiento de solicitudes HTTP separando coordinación, datos o reglas y generación de la respuesta. Adapta el nombre MVC a un ciclo sincrónico de solicitud-respuesta, distinto del bucle interactivo continuo del Smalltalk original.

## Cómo se usa

Un flujo del lado del servidor es:

```text
solicitud -> router -> controlador -> modelo o servicio
respuesta <- vista o serializador <- controlador
```

- El **router** selecciona el controlador según método y ruta.
- El **controlador** valida parámetros de transporte y coordina un caso de uso.
- El **modelo** representa datos y reglas, o delega en servicios de dominio.
- La **vista** renderiza HTML; en una API puede existir un serializador de respuesta en lugar de una vista tradicional.

El controlador no debería contener SQL ni reglas extensas. Los objetos HTTP deben quedarse en el borde; el núcleo recibe tipos con significado propio.

## Por qué y cuándo se usa

Se usa en aplicaciones web del lado del servidor y API con múltiples rutas. Estandariza el ciclo de petición y permite probar controladores, servicios y renderizado por separado.

## Ventajas

- Organización reconocible de rutas y respuestas.
- Separación entre transporte y reglas.
- Pruebas por componente.
- Reutilización del modelo desde varios endpoints.
- Soporte natural en numerosos frameworks.

## Desventajas

- “Modelo” es ambiguo entre entidad, DTO y servicio.
- Controladores pueden crecer y transformarse en clases dominantes.
- En una API JSON, la noción de vista puede ser artificial.
- El framework puede filtrar anotaciones y tipos HTTP a todo el sistema.

## Origen y evolución

Los frameworks web adoptaron el término MVC al trasladar la separación de presentación y modelo al protocolo HTTP. A diferencia del MVC de escritorio, cada solicitud suele crear un ciclo breve y la vista genera una representación que se envía al cliente.

La evolución incorporó front controllers, routers, plantillas, API REST y clientes con estado propio. En aplicaciones de página única, el servidor puede limitarse a una API y la arquitectura de interfaz vivir en el navegador.

## Estado actual

MVC Web continúa vigente en frameworks de servidor. Su versión actual suele combinar controladores delgados con servicios de aplicación y validación declarativa. Debe documentarse si la salida es HTML, JSON u otro formato, porque eso cambia el rol de la vista.

## Ejemplo de esta carpeta

El [README](README.md) y `src/Main.java` simulan ruta, controlador y respuesta sin levantar un servidor. El objetivo es mostrar responsabilidades; un sistema real requiere framework HTTP, seguridad y manejo completo de errores.

## Relación con MVC

La [explicación general de MVC](../EXPLICACIÓN.md) explica por qué esta variante no debe identificarse sin matices con el MVC original.
