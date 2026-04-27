# Proxy

## Proposito

Usar un sustituto con la misma interfaz para controlar el acceso a un objeto real.

## Problema que resuelve

El objeto real puede ser costoso, remoto, protegido o requerir control de ciclo de vida.

## Idea de solucion

El proxy implementa la misma interfaz que el sujeto real y decide cuando crear, validar, cachear o delegar.

## Interaccion entre clases

`LazyImageProxy.display()` recibe la llamada del cliente. Si la imagen real no existe, la crea; luego delega en `HighResolutionImage`.

El archivo `UML.puml` contiene dos vistas: un diagrama de clases, que muestra la estructura estatica, y un diagrama de secuencia, que muestra el flujo de mensajes entre objetos durante una ejecucion tipica.

## Palabras clave para reconocerlo

- `sustituto`
- `misma interfaz`
- `control de acceso`
- `carga diferida`
- `cache`
- `objeto remoto`
- `proteccion`

## Implementacion Java

Cada clase esta separada en un archivo para que la estructura del patron sea visible:

- `src/HighResolutionImage.java`
- `src/Image.java`
- `src/LazyImageProxy.java`
- `src/Main.java`

Para compilar y ejecutar desde esta carpeta:

```bash
javac -encoding UTF-8 src/*.java
java -cp src Main
```

## Tres ejemplos de aplicacion

### Ejemplo 1: Implementacion Generica

**Problematica:** se necesita estudiar la estructura esencial del patron sin ruido accidental de un dominio especifico.

**Como la atiende el patron:** muestra la estructura basica para controlar el acceso a un sujeto real.

### Ejemplo 2: Servicio remoto

**Problematica:** consultar reportes remotos es costoso.

**Como la atiende el patron:** el proxy agrega cache sin cambiar la interfaz del servicio.

### Ejemplo 3: Documentos protegidos

**Problematica:** el acceso debe validarse antes de abrir el documento real.

**Como la atiende el patron:** el proxy controla permisos y luego delega.

## Otras situaciones donde puede usarse

- Carga diferida de recursos pesados.
- Control de permisos.
- Caches transparentes.
