# JUnit 4: tests unitarios para reglas de negocio

Consulta la [explicación detallada](EXPLICACIÓN.md) para estudiar su propósito, uso, evolución, ventajas y limitaciones.

## 1. Idea central

Un test unitario verifica una unidad pequeña de comportamiento en aislamiento razonable. En un sistema académico de solicitudes, las unidades más importantes serían:

- entidades del dominio: `Estudiante`, `Solicitud`, `EstadoSolicitud`, `HistorialEvento`;
- casos de uso: `SolicitudService`;
- reglas de transición: una solicitud pendiente puede cambiar de estado; una solicitud finalizada no debe cambiar;
- interacciones esperadas: al cambiar estado, se guarda, se publica un evento y se notifica.

Un test unitario no debería probar Hibernate, SQLite, JavaFX ni el Event Bus real salvo que ese sea explícitamente el objetivo de una prueba de integración.

## 2. Dependencia Maven mínima

```xml
<dependency>
  <groupId>junit</groupId>
  <artifactId>junit</artifactId>
  <version>${junit.version}</version>
  <scope>test</scope>
</dependency>
```

Una versión compatible para estudiar este material es `JUnit 4.13.2`.

## 3. Sintaxis mínima

```java
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EjemploTest {

    @Test
    public void sumaDebeRetornarResultadoCorrecto() {
        int resultado = 2 + 3;

        assertEquals(5, resultado);
    }
}
```

Lectura:

- `@Test`: marca un método como caso de prueba.
- El método debe ser `public void`.
- Si el método termina sin excepción y las aserciones pasan, el test pasa.
- Si una aserción falla, JUnit lanza un `AssertionError`.

## 4. Estructura AAA

Una forma rigurosa de escribir tests es separar tres momentos:

```text
Arrange: preparar datos, dobles, objeto bajo prueba.
Act: ejecutar exactamente la acción que se quiere probar.
Assert: verificar el resultado observable.
```

Ejemplo aplicado:

```java
@Test
public void solicitudNuevaDebeQuedarPendiente() {
    // Arrange
    Estudiante estudiante = new Estudiante("Ana Torres", "ana@universidad.cl");

    // Act
    Solicitud solicitud = new Solicitud(estudiante, "Certificado", "Alumno regular");

    // Assert
    assertEquals(EstadoSolicitud.PENDIENTE, solicitud.getEstado());
}
```

## 5. Aserciones principales

```java
assertEquals(esperado, actual);
assertTrue(condicion);
assertFalse(condicion);
assertNotNull(valor);
assertNull(valor);
assertSame(mismaReferenciaEsperada, referenciaActual);
assertNotSame(referenciaNoEsperada, referenciaActual);
fail("mensaje si el flujo llegó donde no debía");
```

Principio importante:

```text
Una aserción debe comprobar comportamiento observable, no detalles accidentales.
```

Por ejemplo, es correcto verificar que una solicitud queda `EN_REVISION`; no es tan útil verificar el orden exacto de líneas internas salvo que ese orden sea requisito del negocio.

## 6. Pruebas de excepciones

JUnit 4 permite dos estilos.

### 6.1. Estilo breve con `expected`

```java
@Test(expected = IllegalArgumentException.class)
public void estudianteNoDebeAceptarNombreVacio() {
    new Estudiante(" ", "ana@universidad.cl");
}
```

Ventaja: es corto.

Limitación: solo verifica el tipo de excepción. No permite revisar fácilmente el mensaje ni el punto exacto donde se lanzó.

### 6.2. Estilo explícito con `assertThrows`

Disponible en JUnit 4.13+:

```java
@Test
public void estudianteNoDebeAceptarNombreVacio() {
    IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> new Estudiante(" ", "ana@universidad.cl")
    );

    assertTrue(ex.getMessage().toLowerCase().contains("nombre"));
}
```

Ventaja: permite verificar mensaje, estado posterior y efectos secundarios ausentes.

## 7. `@Before` y datos comunes

```java
private Estudiante estudiante;

@Before
public void preparar() {
    estudiante = new Estudiante("Ana Torres", "ana@universidad.cl");
}
```

JUnit crea una instancia nueva de la clase de test por cada método. Aun así, `@Before` ayuda a preparar datos repetidos de forma legible.

Regla práctica:

```text
Usa @Before para datos realmente comunes. No escondas en @Before información clave para entender un test.
```

## 8. Tests unitarios puros y Mockito

JUnit 4 define cómo se escriben y ejecutan tests. Mockito es otra dependencia: sirve para crear mocks. Para estudiar con claridad, en este material quedan separados:

```text
JUnit4   -> pruebas unitarias puras y aserciones.
Mockito  -> mocks, stubs, verify y ArgumentCaptor.
```

### 8.1. Test unitario puro

No usa mocks. Instancia directamente el objeto probado.

Adecuado para:

- entidades;
- objetos de valor;
- reglas de estado;
- validaciones.

Ejemplo:

```text
Solicitud.cambiarEstado(EN_REVISION)
```

Mockito aparece en una carpeta propia porque tiene su propio DSL.

## 9. Qué probar en un sistema de solicitudes

Prioridad alta:

- creación válida de `Estudiante`;
- rechazo de nombre vacío;
- rechazo de correo vacío;
- creación válida de `Solicitud`;
- rechazo de estudiante nulo;
- rechazo de tipo vacío;
- rechazo de descripción vacía;
- estado inicial `PENDIENTE`;
- cambio válido de estado;
- rechazo de estado nulo;
- rechazo de cambio si la solicitud ya está finalizada;
- reglas puras de dominio con JUnit 4;
- casos de uso con dependencias externas usando Mockito.

## 10. Errores frecuentes

- Probar getters triviales y dejar sin probar reglas de negocio.
- Usar la base de datos real en un test que pretende ser unitario.
- Verificar implementación interna en vez de comportamiento observable.
- Escribir tests con nombres genéricos como `test1`.
- Tener muchas aserciones desconectadas en un mismo test.
- Usar mocks para todo, incluso para entidades simples.
- No probar los caminos de error.

## 11. Archivos de ejemplo

Revisa:

```text
3. JUnit4/JUnit5 (Tests Unitarios)/ejemplos/SolicitudDomainJUnit4ComentadoTest.java
3. JUnit4/JUnit5 (Tests Unitarios)/ejemplos/EstadoSolicitudJUnit4ComentadoTest.java
```

Ambos muestran tests unitarios puros de dominio.

## 12. Fuentes primarias consultadas

- JUnit 4 `@Test`: https://junit.org/junit4/javadoc/4.12/org/junit/Test.html
- JUnit `Assert`: https://junit.org/javadoc/latest/org/junit/Assert.html
