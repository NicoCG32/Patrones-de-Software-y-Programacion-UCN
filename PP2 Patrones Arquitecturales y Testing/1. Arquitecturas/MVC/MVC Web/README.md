# MVC Web

Consulta la [explicación detallada](EXPLICACIÓN.md) para estudiar su propósito, uso, evolución, ventajas y limitaciones.

## Propósito

Mostrar MVC en una aplicación web de forma conceptual, sin usar frameworks. El controlador recibe una petición, consulta el modelo y entrega una vista renderizada como respuesta.

## Estructura

```text
HttpRequest -> ProductoController -> ProductoModel -> HtmlView -> HttpResponse
```

- `HttpRequest`: representa una solicitud web.
- `ProductoController`: coordina la operación.
- `ProductoModel`: contiene datos del dominio.
- `HtmlView`: transforma el modelo en HTML.
- `HttpResponse`: representa la respuesta.

## Regla principal

El controlador no debería construir reglas de dominio complejas ni la vista debería consultar datos por sí misma. El modelo responde datos, la vista los presenta y el controlador une ambas partes.

## Ejecución

```bash
javac -encoding UTF-8 src/*.java
java -cp src Main
```

## Lectura esperada

La salida simula una respuesta HTTP con código de estado y cuerpo HTML.
