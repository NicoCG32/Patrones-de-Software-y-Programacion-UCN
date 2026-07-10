# Microservicios

Consulta la [explicación detallada](EXPLICACIÓN.md) para estudiar su propósito, uso, evolución, ventajas y limitaciones.

## Propósito

Dividir el sistema en servicios pequeños, cada uno responsable de una capacidad de negocio. Cada servicio debería poder evolucionar y desplegarse con cierta autonomía.

## Problema que resuelve

En un sistema grande, un único despliegue monolítico puede obligar a coordinar cambios no relacionados. Microservicios reduce ese acoplamiento operativo, aunque agrega comunicación, monitoreo y consistencia distribuida.

## Estructura del ejemplo

```text
PedidoApp -> CatalogoService
PedidoApp -> PagoService
PedidoApp -> DespachoService
```

El ejemplo no levanta procesos reales ni HTTP. Modela los servicios como clases para concentrarse en la idea arquitectural.

## Regla de dependencia

Cada servicio expone una operación clara y oculta sus datos internos. La aplicación orquesta el caso de uso sin conocer cómo cada servicio resuelve su parte.

## Ejecución

```bash
javac -encoding UTF-8 src/*.java
java -cp src Main
```

## Lectura esperada

El programa valida stock, autoriza pago y agenda despacho. En una implementación real, esos servicios podrían vivir en procesos separados y comunicarse por HTTP o mensajería.
