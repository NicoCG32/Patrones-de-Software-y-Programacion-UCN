# Abstract Factory

Consulta la [explicación detallada](EXPLICACIÓN.md) para estudiar su propósito, uso, evolución, ventajas y limitaciones.

## Proposito

Crear familias de objetos relacionados sin que el cliente dependa de las clases concretas que instancia.

## Problema que resuelve

El sistema necesita productos compatibles entre si. Si el cliente usa `new` sobre clases concretas, cada nueva familia obliga a modificar codigo cliente y rompe el principio abierto/cerrado.

## Idea de solucion

El cliente depende de una fabrica abstracta. Cada fabrica concreta produce una familia completa y coherente de productos.

## Interaccion entre clases

El `Client` recibe una `WidgetFactory`, invoca `createButton()` y `createCheckbox()`, y trabaja solo con las interfaces `Button` y `Checkbox`. La fabrica concreta decide si la familia sera clara u oscura.

El archivo `UML.puml` y los archivos de `fig/` contienen dos vistas: un diagrama de clases, que muestra la estructura estatica, y un diagrama de secuencia, que muestra el flujo de mensajes entre objetos durante una ejecucion tipica.

## Palabras clave para reconocerlo

- `familia de productos`
- `productos compatibles`
- `fabrica concreta`
- `sin clases concretas en el cliente`
- `intercambiar familia completa`

## Implementacion Java

Cada clase esta separada en un archivo para que la estructura del patron sea visible:

- `src/Button.java`
- `src/Checkbox.java`
- `src/Client.java`
- `src/DarkButton.java`
- `src/DarkCheckbox.java`
- `src/DarkWidgetFactory.java`
- `src/LightButton.java`
- `src/LightCheckbox.java`
- `src/LightWidgetFactory.java`
- `src/Main.java`
- `src/WidgetFactory.java`

Para compilar y ejecutar desde esta carpeta:

```bash
javac -encoding UTF-8 src/*.java
java -cp src Main
```

## Tres ejemplos de aplicacion

### Ejemplo 1: Implementacion Generica

**Problematica:** se necesita estudiar la estructura esencial del patron sin ruido accidental de un dominio especifico. **Como la atiende el patron:** muestra la estructura basica de una fabrica abstracta que produce familias completas de objetos compatibles.

### Ejemplo 2: Conectores de bases de datos

**Problematica:** cada motor necesita conexion y comandos compatibles. **Como la atiende el patron:** una fabrica por motor crea una familia coherente de objetos de acceso a datos.

### Ejemplo 3: Familias de vehiculos

**Problematica:** el catalogo debe crear vehiculos electricos o a gasolina sin conocer clases concretas. **Como la atiende el patron:** cada fabrica concreta crea la familia energetica completa.

## Otras situaciones donde puede usarse

- Sistemas multi-marca donde cada marca exige componentes compatibles entre si.
- Aplicaciones que deben intercambiar proveedores completos de servicios.
- Motores de renderizado que crean familias coherentes de recursos.


## Diagramas UML

### Diagrama de clases

![Diagrama de clases UML](fig/ClassDiagram.png)

### Diagrama de secuencia

![Diagrama de secuencia UML](fig/SequenceDiagrama.png)
