# Explicación de la solución

## 1. Problema detectado

El proyecto fallaba por una regla arquitectural de ArchUnit: el controlador dependía directamente de clases de infraestructura.

Antes, `SolicitudController` conocía estas clases concretas:

- `EstudianteRepository`
- `SolicitudRepository`
- `ServicioCorreoExterno`

Eso rompía la separación esperada entre capas, porque el controlador pertenece a la capa de control y no debería saber cómo se guardan datos ni cómo se envían correos.

La dependencia problemática era:

```text
controller -> infra.jpa
controller -> infra.external
```

La solución fue mover la coordinación del caso de uso a la capa de aplicación y dejar al controlador solamente como intermediario entre la vista y el servicio.

---

## 2. Puertos agregados

Se agregaron interfaces simples en la capa de dominio:

```text
domain.repository.EstudiantePort
domain.repository.HistorialEventoPort
```

El proyecto ya tenía:

```text
domain.repository.SolicitudPort
```

Estas interfaces son puertos. Un puerto define qué necesita la aplicación, sin obligarla a conocer la tecnología concreta que cumple esa necesidad.

Por ejemplo, `SolicitudService` necesita guardar y buscar solicitudes, pero no necesita saber si eso se hace con JPA, SQLite, memoria u otra tecnología.

---

## 3. Repositorios adaptados

Los repositorios JPA ahora implementan los puertos:

```text
EstudianteRepository implements EstudiantePort
SolicitudRepository implements SolicitudPort
HistorialEventoRepository implements HistorialEventoPort
```

Con esto, la infraestructura sigue existiendo, pero queda detrás de interfaces.

La idea arquitectural queda así:

```text
Application -> Port <- Infrastructure
```

Esto se llama inversión de dependencias: la capa estable define el contrato, y la capa técnica lo implementa.

---

## 4. Servicio de aplicación

`SolicitudService` ahora concentra los casos de uso principales:

```text
registrarEstudiante(...)
crearSolicitud(...)
cambiarEstado(...)
```

Antes, parte de esa lógica estaba dentro del controlador.

Ahora el flujo es:

```text
View -> Controller -> SolicitudService -> Ports -> Repositories
```

El servicio hace tres tareas importantes:

1. Crea entidades válidas del dominio.
2. Busca y guarda datos usando puertos.
3. Publica eventos y llama al notificador externo cuando el cambio de estado es correcto.

Si la solicitud no existe o el cambio de estado no es válido, el servicio lanza una excepción antes de guardar, publicar eventos o notificar.

---

## 5. Controlador simplificado

`SolicitudController` quedó reducido a delegar:

```java
public Estudiante registrarEstudiante(String nombre, String correo) {
    return solicitudService.registrarEstudiante(nombre, correo);
}
```

El controlador ya no crea repositorios, no crea servicios externos y no importa clases del paquete `infra`.

Su responsabilidad queda limitada a recibir la acción de la vista y pedir al servicio de aplicación que ejecute el caso de uso.

---

## 6. Armado de dependencias

El armado de objetos se movió a `Main`.

Ahí se crean las implementaciones concretas:

```text
EstudianteRepository
SolicitudRepository
HistorialEventoRepository
ServicioCorreoExterno
VertxPublicadorEventosSolicitud
```

Luego esas implementaciones se entregan al servicio por medio de sus interfaces.

Esto evita que la vista o el controlador dependan directamente de infraestructura.

---

## 7. Vert.x y eventos

El cambio de estado sigue usando un estilo publish-subscribe con Vert.x.

El servicio de aplicación publica un `EventoCambioEstadoSolicitud`.

Luego `VertxPublicadorEventosSolicitud` lo envía al event bus de Vert.x.

Finalmente, `HistorialEventosVerticle` recibe el evento y guarda una evidencia en historial.

El flujo queda así:

```text
SolicitudService
    -> PublicadorEventosSolicitud
    -> VertxPublicadorEventosSolicitud
    -> Event Bus Vert.x
    -> HistorialEventosVerticle
    -> HistorialEventoPort
```

El verticle también fue desacoplado: ya no depende directamente de `HistorialEventoRepository`, sino de `HistorialEventoPort`.

---

## 8. Pruebas agregadas o ampliadas

Se ampliaron pruebas en varias capas.

### Dominio

Se probaron reglas como:

- estudiante válido;
- rechazo de nombre vacío;
- rechazo de correo vacío;
- solicitud válida;
- rechazo de estudiante nulo;
- rechazo de tipo vacío;
- rechazo de descripción vacía;
- estado inicial pendiente;
- cambio válido de estado;
- rechazo de estado nulo;
- rechazo de cambio cuando la solicitud ya está finalizada;
- identificación de estados finales.

### Aplicación con Mockito

Se probaron los casos de uso de `SolicitudService` con mocks:

- registrar estudiante;
- crear solicitud;
- rechazar estudiante inexistente;
- cambiar estado correctamente;
- guardar la solicitud actualizada;
- publicar evento;
- enviar notificación externa;
- no guardar, no publicar y no notificar cuando la solicitud no existe;
- no guardar, no publicar y no notificar cuando la solicitud ya está finalizada.

### Controlador

Se probó que el controlador delega en `SolicitudService` sin asumir responsabilidades técnicas.

### Vert.x

Se agregó una prueba del flujo publish-subscribe:

1. Se despliega `HistorialEventosVerticle`.
2. Se publica un evento con `VertxPublicadorEventosSolicitud`.
3. Se verifica que el receptor guarda evidencia del evento recibido.

### JPA

Se agregó una prueba de integración sencilla para verificar que los repositorios guardan y buscan:

- estudiantes;
- solicitudes;
- eventos de historial.

---

## 9. Cobertura

`mvn verify` exigía una cobertura mínima de 80%.

Se agregó cobertura sobre dominio, aplicación, controlador, mensajería, servicio externo y repositorios.

También se excluyeron de la regla de cobertura estas piezas:

```text
cl/ucn/solicitudes/Main*
cl/ucn/solicitudes/view/SolicitudJavaFxView*
```

La razón es que `Main` es código de arranque y `SolicitudJavaFxView` es interfaz gráfica JavaFX. No son buenos objetivos para pruebas unitarias simples.

La lógica evaluable del sistema queda cubierta por pruebas automatizadas.

La cobertura efectiva sobre las clases incluidas por la regla quedó en:

```text
197/200 líneas = 98,50%
```

---

## 10. Validación final

Se ejecutó:

```bash
mvn test
```

Resultado:

```text
Tests run: 30, Failures: 0, Errors: 0, Skipped: 0
```

También se ejecutó:

```bash
mvn verify
```

Resultado:

```text
BUILD SUCCESS
All coverage checks have been met.
```

Con esto, el proyecto cumple los objetivos principales:

- el controlador ya no depende de infraestructura;
- las reglas arquitecturales pasan;
- los casos de negocio principales están probados;
- Mockito se usa para aislar dependencias externas;
- Vert.x mantiene comunicación orientada a eventos;
- la cobertura mínima exigida se cumple.