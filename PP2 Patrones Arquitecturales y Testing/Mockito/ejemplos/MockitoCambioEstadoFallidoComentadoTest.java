package cl.ucn.solicitudes.application;

import cl.ucn.solicitudes.domain.model.EstadoSolicitud;
import cl.ucn.solicitudes.domain.model.Solicitud;
import cl.ucn.solicitudes.domain.repository.EstudiantePort;
import cl.ucn.solicitudes.domain.repository.SolicitudPort;
import cl.ucn.solicitudes.domain.service.NotificadorExterno;
import cl.ucn.solicitudes.domain.service.PublicadorEventosSolicitud;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Ejemplo 2: Mockito en un caso fallido.
 *
 * Objetivo:
 * Si la solicitud no existe, el servicio debe fallar sin guardar, sin publicar
 * evento y sin enviar correo.
 */
public class MockitoCambioEstadoFallidoComentadoTest {

    @Test
    public void solicitudInexistenteNoDebeProducirEfectosSecundarios() {
        // Arrange: dependencias falsas.
        EstudiantePort estudiantePort = mock(EstudiantePort.class);
        SolicitudPort solicitudPort = mock(SolicitudPort.class);
        PublicadorEventosSolicitud publicador = mock(PublicadorEventosSolicitud.class);
        NotificadorExterno notificador = mock(NotificadorExterno.class);

        // El repositorio simulado responde que la solicitud no existe.
        when(solicitudPort.buscarPorId(99L)).thenReturn(Optional.empty());

        // Unidad bajo prueba.
        SolicitudService service = new SolicitudService(
                estudiantePort,
                solicitudPort,
                publicador,
                notificador
        );

        // Act + Assert: el caso de uso debe lanzar excepción.
        assertThrows(
                IllegalArgumentException.class,
                () -> service.cambiarEstado(99L, EstadoSolicitud.EN_REVISION)
        );

        // Assert: como no existe la solicitud, no debe guardar.
        verify(solicitudPort, never()).guardar(any(Solicitud.class));

        // Assert: tampoco debe publicar eventos falsos.
        verify(publicador, never()).publicar(any(EventoCambioEstadoSolicitud.class));

        // Assert: tampoco debe enviar correos por una operación inválida.
        verify(notificador, never()).enviarCorreo(anyString(), anyString(), anyString());
    }
}

