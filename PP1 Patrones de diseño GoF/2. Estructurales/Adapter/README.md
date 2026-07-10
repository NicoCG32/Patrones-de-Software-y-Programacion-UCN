# Adapter

Consulta la [explicación detallada](EXPLICACIÓN.md) para estudiar su propósito, uso, evolución, ventajas y limitaciones.

## Proposito

Convertir la interfaz de una clase existente en la interfaz que espera el cliente.

## Problema que resuelve

Existe una clase util o heredada, pero su contrato no coincide con el contrato requerido por el sistema actual.

## Idea de solucion

El adaptador implementa la interfaz objetivo y traduce sus llamadas hacia el objeto adaptado.

## Interaccion entre clases

`CheckoutService` invoca `PaymentProcessor.pay(cents)`. `PaymentGatewayAdapter` convierte centavos a monto decimal y delega en `LegacyPaymentGateway`.

El archivo `UML.puml` contiene dos vistas: un diagrama de clases, que muestra la estructura estatica, y un diagrama de secuencia, que muestra el flujo de mensajes entre objetos durante una ejecucion tipica.

## Palabras clave para reconocerlo

- `interfaz incompatible`
- `adaptador`
- `wrapper`
- `legacy`
- `traducir llamadas`
- `reutilizar clase existente`

## Implementacion Java

Cada clase esta separada en un archivo para que la estructura del patron sea visible:

- `src/CheckoutService.java`
- `src/LegacyPaymentGateway.java`
- `src/Main.java`
- `src/PaymentGatewayAdapter.java`
- `src/PaymentProcessor.java`

Para compilar y ejecutar desde esta carpeta:

```bash
javac -encoding UTF-8 src/*.java
java -cp src Main
```

## Tres ejemplos de aplicacion

### Ejemplo 1: Implementacion Generica

**Problematica:** se necesita estudiar la estructura esencial del patron sin ruido accidental de un dominio especifico. **Como la atiende el patron:** muestra la estructura basica para traducir una interfaz incompatible.

### Ejemplo 2: API externa incompatible

**Problematica:** el proveedor entrega XML y el dominio espera objetos. **Como la atiende el patron:** el adaptador traduce el contrato externo al interno.

### Ejemplo 3: Biblioteca con unidades distintas

**Problematica:** la biblioteca trabaja en millas y el dominio en kilometros. **Como la atiende el patron:** el adaptador concentra la conversion de unidades.

## Otras situaciones donde puede usarse

- Integracion con APIs externas.
- Reutilizacion de bibliotecas antiguas.
- Conversion entre unidades o formatos.
