package cl.ucn.solicitudes.view;

import cl.ucn.solicitudes.controller.SolicitudController;
import cl.ucn.solicitudes.domain.model.EstadoSolicitud;
import cl.ucn.solicitudes.domain.model.Estudiante;
import cl.ucn.solicitudes.domain.model.Solicitud;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ConsoleViewTest {

    @Test
    public void demoDebeDelegarFlujoBasicoEnControlador() {
        SolicitudController controller = mock(SolicitudController.class);
        Estudiante estudiante = new Estudiante("Ana Torres", "ana@universidad.cl");
        Solicitud solicitud = new Solicitud(estudiante, "Certificado", "Solicitud valida");

        when(controller.registrarEstudiante(eq("Ana Torres"), anyString()))
                .thenReturn(estudiante);
        when(controller.crearSolicitud(isNull(), eq("Certificado"), anyString()))
                .thenReturn(solicitud);
        when(controller.cambiarEstado(isNull(), eq(EstadoSolicitud.EN_REVISION)))
                .thenReturn(solicitud);

        PrintStream salidaOriginal = System.out;
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));

        try {
            ConsoleView view = new ConsoleView(controller);
            view.demo();

            assertTrue(salida.toString().contains("Solicitud creada"));
            verify(controller).registrarEstudiante(eq("Ana Torres"), anyString());
            verify(controller).crearSolicitud(isNull(), eq("Certificado"), anyString());
            verify(controller).cambiarEstado(isNull(), eq(EstadoSolicitud.EN_REVISION));
        } finally {
            System.setOut(salidaOriginal);
        }
    }

    @Test
    public void placeholderJavaFxDebePoderConstruirse() {
        new JavaFxPlaceholderView();
    }
}
