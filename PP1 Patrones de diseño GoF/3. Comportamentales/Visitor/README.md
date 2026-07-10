# Visitor

Consulta la [explicación detallada](EXPLICACIÓN.md) para estudiar su propósito, uso, evolución, ventajas y limitaciones.

## Proposito

Agregar operaciones sobre una estructura de objetos sin modificar las clases de los elementos.

## Problema que resuelve

Una jerarquia estable necesita nuevas operaciones transversales. Ponerlas dentro de cada elemento mezcla responsabilidades.

## Idea de solucion

Cada elemento implementa `accept(visitor)`. El visitor contiene una operacion por tipo concreto de elemento.

## Interaccion entre clases

El cliente recorre elementos y llama `accept(visitor)`. Cada elemento invoca el metodo `visit` correspondiente, produciendo doble despacho.

El archivo `UML.puml` contiene dos vistas: un diagrama de clases, que muestra la estructura estatica, y un diagrama de secuencia, que muestra el flujo de mensajes entre objetos durante una ejecucion tipica.

## Palabras clave para reconocerlo

- `visit`
- `accept`
- `doble despacho`
- `operacion transversal`
- `estructura estable`
- `nuevas operaciones`

## Implementacion Java

Cada clase esta separada en un archivo para que la estructura del patron sea visible:

- `src/DocumentElement.java`
- `src/Image.java`
- `src/Main.java`
- `src/Paragraph.java`
- `src/PlainTextExportVisitor.java`
- `src/Visitor.java`

Para compilar y ejecutar desde esta carpeta:

```bash
javac -encoding UTF-8 src/*.java
java -cp src Main
```

## Tres ejemplos de aplicacion

### Ejemplo 1: Implementacion Generica

**Problematica:** se necesita estudiar la estructura esencial del patron sin ruido accidental de un dominio especifico. **Como la atiende el patron:** muestra la estructura basica para aplicar operaciones sobre elementos sin modificarlos.

### Ejemplo 2: Analisis de arbol sintactico

**Problematica:** un AST estable necesita operaciones nuevas. **Como la atiende el patron:** el visitor aplica operaciones sin modificar los nodos.

### Ejemplo 3: Auditoria de items

**Problematica:** items distintos requieren auditoria transversal. **Como la atiende el patron:** el visitor implementa la auditoria por tipo concreto.

## Otras situaciones donde puede usarse

- Operaciones nuevas sobre jerarquias estables.
- Analisis de AST.
- Reportes sobre estructuras heterogeneas.
