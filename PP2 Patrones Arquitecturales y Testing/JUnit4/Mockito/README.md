# Mockito: dobles de prueba para aislar dependencias

## 1. Idea central

Mockito permite crear objetos falsos controlados por el test. Se usa cuando la unidad probada depende de algo que no conviene ejecutar en una prueba unitaria:

- base de datos;
- correo externo;
- Event Bus real;
- API externa;
- repositorio JPA;
- componente lento o difícil de preparar.

En la Formativa PSP, Mockito se usa principalmente para probar `SolicitudService` sin llamar infraestructura real.

## 2. Dependencia Maven usada en la Formativa

```xml
<dependency>
  <groupId>org.mockito</groupId>
  <artifactId>mockito-core</artifactId>
  <version>${mockito.version}</version>
  <scope>test</scope>
</dependency>
```

La Formativa usa `Mockito 4.11.0`.

## 3. DSL mínimo de Mockito

Mockito se lee con una gramática simple:

```text
crear mock
    -> preparar respuesta
    -> ejecutar caso de uso
    -> verificar interacción
```

En código:

```java
SolicitudPort solicitudPort = mock(SolicitudPort.class);

when(solicitudPort.buscarPorId(10L))
        .thenReturn(Optional.of(solicitud));

service.cambiarEstado(10L, EstadoSolicitud.EN_REVISION);

verify(solicitudPort).guardar(any(Solicitud.class));
```

## 4. Operaciones principales

### 4.1. `mock`

Crea una dependencia falsa:

```java
SolicitudPort solicitudPort = mock(SolicitudPort.class);
```

Uso típico:

```text
Reemplazar un repositorio, servicio externo, publicador de eventos o adaptador técnico.
```

### 4.2. `when(...).thenReturn(...)`

Define qué responderá el mock:

```java
when(solicitudPort.buscarPorId(10L))
        .thenReturn(Optional.of(solicitud));
```

Uso típico:

```text
Simular que una solicitud existe.
Simular que un estudiante no existe.
Simular que un repositorio retorna el objeto guardado.
```

### 4.3. `thenAnswer`

Permite calcular la respuesta según los argumentos recibidos:

```java
when(solicitudPort.guardar(any(Solicitud.class)))
        .thenAnswer(invocation -> invocation.getArgument(0));
```

Uso típico:

```text
Simular un guardado simple sin base de datos.
```

### 4.4. `verify`

Comprueba que una dependencia fue llamada:

```java
verify(solicitudPort).guardar(any(Solicitud.class));
```

Uso típico:

```text
Verificar que el caso de uso guardó, publicó o notificó.
```

### 4.5. `never`

Comprueba que una dependencia no fue llamada:

```java
verify(notificador, never()).enviarCorreo(anyString(), anyString(), anyString());
```

Uso típico:

```text
Si el caso de uso falla, no debe enviar correos ni publicar eventos.
```

### 4.6. Matchers: `any`, `eq`, `contains`

Permiten verificar argumentos sin escribir todo el objeto exacto:

```java
verify(notificador).enviarCorreo(
        eq("ana@universidad.cl"),
        anyString(),
        contains("EN_REVISION")
);
```

Lectura:

```text
El destinatario debe ser exactamente ese correo.
El asunto puede ser cualquier String.
El cuerpo debe contener EN_REVISION.
```

### 4.7. `ArgumentCaptor`

Captura un argumento para revisarlo con detalle:

```java
ArgumentCaptor<EventoCambioEstadoSolicitud> captor =
        ArgumentCaptor.forClass(EventoCambioEstadoSolicitud.class);

verify(publicador).publicar(captor.capture());

assertEquals(EstadoSolicitud.PENDIENTE, captor.getValue().getEstadoAnterior());
```

Uso típico:

```text
Verificar el contenido exacto de un evento publicado.
```

## 5. Usos generales

Mockito sirve para:

- probar servicios de aplicación;
- aislar infraestructura;
- simular casos de éxito;
- simular casos de error;
- verificar efectos secundarios;
- comprobar que una dependencia fue llamada una vez, varias veces o nunca;
- capturar argumentos enviados a un colaborador;
- evitar pruebas lentas o frágiles.

Mockito no es necesario para:

- probar entidades simples;
- probar objetos de valor;
- probar métodos puros;
- reemplazar todo el sistema sin criterio.

## 6. Aplicación directa a la Formativa PSP

Caso de uso:

```text
SolicitudService.cambiarEstado(...)
```

Dependencias reales que se reemplazan:

```text
SolicitudPort              -> mock
EstudiantePort             -> mock
PublicadorEventosSolicitud -> mock
NotificadorExterno         -> mock
```

Se verifica:

```text
1. La solicitud se guarda.
2. El evento se publica.
3. El correo se envía.
4. Si la solicitud no existe, nada de eso ocurre.
```

## 7. Ejemplos comentados

Revisa:

```text
Mockito/ejemplos/MockitoCambioEstadoExitosoComentadoTest.java
Mockito/ejemplos/MockitoCambioEstadoFallidoComentadoTest.java
```

Ambos son deliberadamente pequeños para estudiar la sintaxis sin ruido.

