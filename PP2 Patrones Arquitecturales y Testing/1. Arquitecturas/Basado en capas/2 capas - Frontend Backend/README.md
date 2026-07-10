# Arquitectura De 2 Capas: Frontend Y Backend

Consulta la [explicación detallada](EXPLICACIÓN.md) para estudiar su propósito, uso, evolución, ventajas y limitaciones.

## Propósito

Separar la parte que interactúa con el usuario de la parte que ejecuta reglas y entrega datos. Es una división mínima y común en aplicaciones cliente-servidor.

## Estructura

```text
Frontend -> Backend
```

- `Frontend`: construye una petición y muestra la respuesta.
- `Backend`: valida la petición y produce el resultado.

## Regla principal

El frontend no calcula la regla central. El backend no decide cómo se presenta visualmente el resultado.

## Ejecución

```bash
javac -encoding UTF-8 src/*.java
java -cp src Main
```

## Lectura esperada

El ejemplo simula un frontend que pide el promedio de notas. El backend recibe la petición, calcula y devuelve un mensaje.
