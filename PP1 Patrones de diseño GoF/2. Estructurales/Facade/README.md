# Facade

Consulta la [explicación detallada](EXPLICACIÓN.md) para estudiar su propósito, uso, evolución, ventajas y limitaciones.

## Proposito

Proporcionar una interfaz simple para un subsistema complejo.

## Problema que resuelve

El cliente debe conocer y coordinar muchas clases internas para realizar una operacion comun.

## Idea de solucion

La fachada expone operaciones de alto nivel y delega internamente en las clases del subsistema.

## Interaccion entre clases

`OrderFacade.placeOrder()` consulta inventario, cobra y agenda envio. El cliente solo ve una operacion de negocio.

El archivo `UML.puml` y los archivos de `fig/` contienen dos vistas: un diagrama de clases, que muestra la estructura estatica, y un diagrama de secuencia, que muestra el flujo de mensajes entre objetos durante una ejecucion tipica.

## Palabras clave para reconocerlo

- `interfaz simple`
- `subsistema complejo`
- `punto de entrada`
- `ocultar complejidad`
- `coordinar clases`
- `API de alto nivel`

## Implementacion Java

Cada clase esta separada en un archivo para que la estructura del patron sea visible:

- `src/Inventory.java`
- `src/Main.java`
- `src/OrderFacade.java`
- `src/Payment.java`
- `src/Shipping.java`

Para compilar y ejecutar desde esta carpeta:

```bash
javac -encoding UTF-8 src/*.java
java -cp src Main
```

## Tres ejemplos de aplicacion

### Ejemplo 1: Implementacion Generica

**Problematica:** se necesita estudiar la estructura esencial del patron sin ruido accidental de un dominio especifico. **Como la atiende el patron:** muestra la estructura basica para simplificar el acceso a un subsistema.

### Ejemplo 2: Arranque de aplicacion

**Problematica:** iniciar exige coordinar configuracion, logs y base de datos. **Como la atiende el patron:** la fachada ofrece un metodo `start()` de alto nivel.

### Ejemplo 3: Conversion multimedia

**Problematica:** convertir video requiere decodificar, filtrar y exportar. **Como la atiende el patron:** la fachada coordina el subsistema multimedia.

## Otras situaciones donde puede usarse

- APIs simples sobre subsistemas complejos.
- Arranque ordenado de aplicaciones.
- Flujos de negocio con varios servicios.


## Diagramas UML

### Diagrama de clases

![Diagrama de clases UML](fig/ClassDiagram.png)

### Diagrama de secuencia

![Diagrama de secuencia UML](fig/SequenceDiagrama.png)
