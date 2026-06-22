package cl.ucn.solicitudes.domain.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Ejemplo 2 de JUnit 4 puro.
 *
 * Objetivo:
 * Probar una regla pequeña y estable del dominio sin Mockito, sin base de
 * datos y sin infraestructura.
 */
public class EstadoSolicitudJUnit4ComentadoTest {

    @Test
    public void pendienteYEnRevisionNoDebenSerEstadosFinales() {
        // Arrange no es necesario porque los enum ya existen.

        // Act + Assert: se verifica la regla de negocio directamente.
        assertFalse(EstadoSolicitud.PENDIENTE.esFinal());
        assertFalse(EstadoSolicitud.EN_REVISION.esFinal());
    }

    @Test
    public void aprobadaYRechazadaDebenSerEstadosFinales() {
        // Una solicitud finalizada no debería permitir nuevas transiciones.
        assertTrue(EstadoSolicitud.APROBADA.esFinal());
        assertTrue(EstadoSolicitud.RECHAZADA.esFinal());
    }
}

