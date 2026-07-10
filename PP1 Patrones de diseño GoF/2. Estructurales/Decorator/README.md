# Decorator

Consulta la [explicación detallada](EXPLICACIÓN.md) para estudiar su propósito, uso, evolución, ventajas y limitaciones.

## Proposito

Agregar responsabilidades a un objeto dinamicamente sin cambiar su interfaz.

## Problema que resuelve

Se requieren combinaciones flexibles de funcionalidades. Crear una subclase por combinacion produce una explosion de clases.

## Idea de solucion

Cada decorador implementa la misma interfaz del componente, contiene otro componente y agrega comportamiento antes o despues de delegar.

## Interaccion entre clases

`SignedMessage` envuelve a `EncryptedMessage`, que envuelve a `PlainMessage`. La llamada `content()` atraviesa las capas y cada una agrega su responsabilidad.

El archivo `UML.puml` contiene dos vistas: un diagrama de clases, que muestra la estructura estatica, y un diagrama de secuencia, que muestra el flujo de mensajes entre objetos durante una ejecucion tipica.

## Palabras clave para reconocerlo

- `envolver objeto`
- `misma interfaz`
- `responsabilidades dinamicas`
- `capas`
- `composicion`
- `evitar explosion de subclases`

## Implementacion Java

Cada clase esta separada en un archivo para que la estructura del patron sea visible:

- `src/EncryptedMessage.java`
- `src/Main.java`
- `src/Message.java`
- `src/MessageDecorator.java`
- `src/PlainMessage.java`
- `src/SignedMessage.java`

Para compilar y ejecutar desde esta carpeta:

```bash
javac -encoding UTF-8 src/*.java
java -cp src Main
```

## Tres ejemplos de aplicacion

### Ejemplo 1: Implementacion Generica

**Problematica:** se necesita estudiar la estructura esencial del patron sin ruido accidental de un dominio especifico. **Como la atiende el patron:** muestra la estructura basica para agregar responsabilidades mediante envoltorios.

### Ejemplo 2: Flujos de datos

**Problematica:** un stream puede requerir buffer y cifrado en distintas combinaciones. **Como la atiende el patron:** cada decorador agrega una responsabilidad manteniendo la interfaz.

### Ejemplo 3: Calculo de precios

**Problematica:** impuestos y envio deben combinarse sin subclases por combinacion. **Como la atiende el patron:** cada regla envuelve el calculo anterior.

## Otras situaciones donde puede usarse

- Middleware HTTP combinable.
- Streams con compresion o cifrado.
- Reglas de precio acumulables.
