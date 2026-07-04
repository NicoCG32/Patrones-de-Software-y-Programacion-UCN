package cl.ucn.solicitudes.infra.external;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class ServicioCorreoExternoTest {

    @Test
    public void enviarCorreoDebeEscribirDatosDelMensaje() {
        PrintStream salidaOriginal = System.out;
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));

        try {
            ServicioCorreoExterno servicio = new ServicioCorreoExterno();

            servicio.enviarCorreo(
                    "ana@universidad.cl",
                    "Cambio de estado",
                    "Su solicitud cambio"
            );

            String texto = salida.toString();
            assertTrue(texto.contains("ana@universidad.cl"));
            assertTrue(texto.contains("Cambio de estado"));
            assertTrue(texto.contains("Su solicitud cambio"));
        } finally {
            System.setOut(salidaOriginal);
        }
    }
}
