package cl.ucn.solicitudes.domain.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

/**
 * Ejemplo académico de tests unitarios puros con JUnit 4.
 *
 * Un test unitario puro no usa base de datos, no usa JavaFX, no usa Vert.x y
 * no usa servicios externos. Aquí se prueba solamente el comportamiento del
 * dominio: validaciones y cambios de estado.
 *
 * Para usarlo en la Formativa, copiarlo a:
 *
 * src/test/java/cl/ucn/solicitudes/domain/model/SolicitudDomainJUnit4ComentadoTest.java
 */
public class SolicitudDomainJUnit4ComentadoTest {

    // Fixture compartido: estudiante válido usado por varios tests.
    private Estudiante estudianteValido;

    /**
     * JUnit ejecuta este método antes de cada @Test.
     *
     * Aunque el dato se comparte como idea, cada test recibe una instancia
     * nueva de la clase de test, por lo que no se arrastra estado entre tests.
     */
    @Before
    public void prepararDatosComunes() {
        estudianteValido = new Estudiante("Ana Torres", "ana@universidad.cl");
    }

    @Test
    public void estudianteValidoDebeConservarNombreYCorreo() {
        // Arrange + Act: se crea directamente la unidad bajo prueba.
        Estudiante estudiante = new Estudiante("Luis Rojas", "luis@universidad.cl");

        // Assert: se verifica el comportamiento observable del constructor.
        assertEquals("Luis Rojas", estudiante.getNombre());
        assertEquals("luis@universidad.cl", estudiante.getCorreo());
    }

    @Test
    public void estudianteNoDebeAceptarNombreVacio() {
        // Act + Assert: se espera una excepción específica.
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> new Estudiante(" ", "ana@universidad.cl")
        );

        // Se revisa el mensaje para confirmar que falló por la razón esperada.
        assertTrue(ex.getMessage().toLowerCase().contains("nombre"));
    }

    @Test
    public void solicitudNuevaDebeQuedarPendiente() {
        // Arrange: se usa un estudiante válido.
        Estudiante estudiante = estudianteValido;

        // Act: se crea una solicitud académica.
        Solicitud solicitud = new Solicitud(
                estudiante,
                "Certificado",
                "Solicita certificado de alumno regular"
        );

        // Assert: el estado inicial pertenece a la regla de negocio.
        assertEquals(EstadoSolicitud.PENDIENTE, solicitud.getEstado());
        assertEquals(estudiante, solicitud.getEstudiante());
        assertNotNull(solicitud.getFechaCreacion());
    }

    @Test
    public void solicitudNoDebeAceptarEstudianteNulo() {
        // Act + Assert: una solicitud sin estudiante asociado es inválida.
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> new Solicitud(null, "Certificado", "Descripción válida")
        );

        // La aserción evita que el test pase por una excepción accidental.
        assertTrue(ex.getMessage().toLowerCase().contains("estudiante"));
    }

    @Test
    public void solicitudDebeCambiarAEstadoEnRevision() {
        // Arrange: se prepara una solicitud en estado inicial PENDIENTE.
        Solicitud solicitud = new Solicitud(
                estudianteValido,
                "Certificado",
                "Solicita certificado de alumno regular"
        );

        // Act: se ejecuta la transición que se quiere probar.
        solicitud.cambiarEstado(EstadoSolicitud.EN_REVISION);

        // Assert: se verifica el nuevo estado y la evidencia temporal.
        assertEquals(EstadoSolicitud.EN_REVISION, solicitud.getEstado());
        assertNotNull(solicitud.getFechaActualizacion());
    }

    @Test
    public void solicitudFinalizadaNoDebeCambiarDeEstado() {
        // Arrange: se crea una solicitud y se lleva a un estado final.
        Solicitud solicitud = new Solicitud(
                estudianteValido,
                "Certificado",
                "Solicita certificado de alumno regular"
        );
        solicitud.cambiarEstado(EstadoSolicitud.APROBADA);

        // Act + Assert: una vez aprobada, no debe volver a EN_REVISION.
        IllegalStateException ex = assertThrows(
                IllegalStateException.class,
                () -> solicitud.cambiarEstado(EstadoSolicitud.EN_REVISION)
        );

        // Se verifica que el mensaje comunica la regla violada.
        assertTrue(ex.getMessage().toLowerCase().contains("finalizada"));

        // Se verifica que el estado no cambió después del intento inválido.
        assertEquals(EstadoSolicitud.APROBADA, solicitud.getEstado());
    }
}

