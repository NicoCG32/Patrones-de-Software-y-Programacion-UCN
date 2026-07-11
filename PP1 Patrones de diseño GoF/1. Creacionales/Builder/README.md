# Builder

Consulta la [explicación detallada](EXPLICACIÓN.md) para estudiar su propósito, uso, evolución, ventajas y limitaciones.

## Proposito

Separar la construccion paso a paso de un objeto complejo de su representacion final.

## Problema que resuelve

Un objeto complejo requiere varios pasos, parametros opcionales o validaciones de orden. Un constructor enorme vuelve dificil leer, validar y extender la creacion.

## Idea de solucion

Un `Director` fija el algoritmo de construccion y un `Builder` concreta cada paso. Cambiar el builder cambia el producto sin cambiar la secuencia.

## Interaccion entre clases

El `Director` invoca pasos sobre `ReportBuilder`. `ExecutiveReportBuilder` acumula estado en `Report` y devuelve el resultado al final.

El archivo `UML.puml` y los archivos de `fig/` contienen dos vistas: un diagrama de clases, que muestra la estructura estatica, y un diagrama de secuencia, que muestra el flujo de mensajes entre objetos durante una ejecucion tipica.

## Palabras clave para reconocerlo

- `construccion paso a paso`
- `objeto complejo`
- `director`
- `producto final`
- `muchos parametros`
- `representaciones alternativas`

## Implementacion Java

Cada clase esta separada en un archivo para que la estructura del patron sea visible:

- `src/Director.java`
- `src/ExecutiveReportBuilder.java`
- `src/Main.java`
- `src/Report.java`
- `src/ReportBuilder.java`

Para compilar y ejecutar desde esta carpeta:

```bash
javac -encoding UTF-8 src/*.java
java -cp src Main
```

## Tres ejemplos de aplicacion

### Ejemplo 1: Implementacion Generica

**Problematica:** se necesita estudiar la estructura esencial del patron sin ruido accidental de un dominio especifico. **Como la atiende el patron:** muestra la estructura basica para construir un objeto complejo mediante pasos ordenados.

### Ejemplo 2: Consultas SQL dinamicas

**Problematica:** la consulta tiene partes opcionales y un orden valido. **Como la atiende el patron:** el builder encadena pasos semanticos y valida antes de construir.

### Ejemplo 3: Datos de prueba

**Problematica:** los tests requieren objetos validos con pequenas variaciones. **Como la atiende el patron:** el builder entrega valores por defecto y permite sobrescribir solo lo necesario.

## Otras situaciones donde puede usarse

- Mensajes complejos con secciones opcionales.
- Pipelines con pasos obligatorios y extensiones opcionales.
- Documentos con muchas partes parametrizables.

## Version moderna sin Director

Ademas de la version clasica con `Director`, este repositorio incluye tres ejemplos de Builder moderno sin Director:

- `Ejemplo 4 - Builder moderno sin Director para configuracion HTTP`: configuracion fluida con parametros opcionales y validacion final.
- `Ejemplo 5 - Builder moderno sin Director para orden de compra`: acumulacion de items, descuento y metodo de despacho antes de construir la orden.
- `Ejemplo 6 - Builder moderno sin Director para perfil de usuario`: construccion de un objeto de perfil con valores por defecto y metodos semanticos.

Esta variante es adecuada cuando el orden de construccion no necesita extraerse como una receta independiente. El cliente usa una API fluida y el metodo `build()` concentra la validacion.


## Diagramas UML

### Diagrama de clases

![Diagrama de clases UML](fig/ClassDiagram.png)

### Diagrama de secuencia

![Diagrama de secuencia UML](fig/SequenceDiagrama.png)
