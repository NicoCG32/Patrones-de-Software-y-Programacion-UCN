# Builder moderno sin Director para orden de compra

## Patron aplicado

Builder moderno sin Director.

## Problematica

Una orden tiene comprador obligatorio, lineas variables, descuento opcional y metodo de despacho. Construirla con listas y parametros sueltos dispersa reglas de validez.

## Como la atiende el patron

El builder acumula lineas de compra, aplica opciones y valida que la orden tenga comprador y al menos un item antes de construirla.

## Diferencia con la version clasica con Director

En la version clasica, un `Director` conoce la secuencia de construccion y llama metodos como `buildHeader()`, `buildBody()` y `buildFooter()`. En esta version moderna, el propio `Builder` ofrece una API fluida: el cliente encadena metodos expresivos y finalmente llama a `build()`.

Esto simplifica el diseno cuando la secuencia no necesita estar encapsulada como algoritmo reutilizable. El `Director` sigue siendo util cuando hay recetas de construccion repetidas, complejas o institucionalizadas.

## Organizacion del proyecto

- `src/main`: contiene el punto de entrada del sistema.
- `src/pattern`: contiene el producto y su builder fluido.

## Ejecutar

```bash
mkdir out
javac -encoding UTF-8 -d out src/pattern/*.java src/main/*.java
java -cp out main.Main
```

## UML de la implementacion

![UML de la implementacion](UML.png)
