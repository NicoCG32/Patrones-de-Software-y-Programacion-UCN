# Arquitectura De 3 Capas: Vista, Servicio Y Persistencia

Consulta la [explicación detallada](EXPLICACIÓN.md) para estudiar su propósito, uso, evolución, ventajas y limitaciones.

## Propósito

Separar la interfaz, el caso de uso y el acceso a datos. Es una de las formas más usadas para explicar arquitectura por capas en cursos de programación orientada a objetos.

## Estructura

```text
Vista -> Servicio -> Persistencia
```

- `Vista`: recibe o muestra información.
- `Servicio`: valida y ejecuta el caso de uso.
- `Persistencia`: guarda o recupera datos.

## Regla principal

La vista no debe hablar directamente con persistencia. Si lo hace, empieza a mezclar presentación con detalles técnicos de almacenamiento.

## Ejecución

```bash
javac -encoding UTF-8 src/*.java
java -cp src Main
```

## Lectura esperada

El ejemplo registra libros. La vista solicita la operación, el servicio valida el título y la persistencia conserva los datos en memoria.
