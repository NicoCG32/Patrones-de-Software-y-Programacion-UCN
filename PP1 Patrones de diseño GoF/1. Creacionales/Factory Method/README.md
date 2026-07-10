# Factory Method

Consulta la [explicación detallada](EXPLICACIÓN.md) para estudiar su propósito, uso, evolución, ventajas y limitaciones.

Material principal del patron.

## Tres ejemplos de aplicacion

### Ejemplo 1: Implementacion Generica

**Problematica:** se necesita estudiar la estructura esencial del patron sin ruido accidental de un dominio especifico. **Como la atiende el patron:** muestra la estructura basica donde una subclase decide que producto concreto crear.

### Ejemplo 2: Transporte logistico

**Problematica:** el flujo logistico es comun, pero el transporte varia. **Como la atiende el patron:** cada subclase creadora instancia el transporte adecuado.

### Ejemplo 3: Dialogos multiplataforma

**Problematica:** el dialogo es comun, pero el boton depende de la plataforma. **Como la atiende el patron:** cada dialogo concreto fabrica su control nativo.

## Otras situaciones donde puede usarse

- Frameworks que delegan creacion en subclases.
- Procesos con flujo comun y recursos variables.
- Plugins que crean manejadores concretos.
