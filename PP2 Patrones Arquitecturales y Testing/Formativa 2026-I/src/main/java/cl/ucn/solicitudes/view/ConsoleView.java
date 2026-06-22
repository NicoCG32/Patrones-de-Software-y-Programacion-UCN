package cl.ucn.solicitudes.view;

import cl.ucn.solicitudes.controller.SolicitudController;
import cl.ucn.solicitudes.domain.model.EstadoSolicitud;
import cl.ucn.solicitudes.domain.model.Estudiante;
import cl.ucn.solicitudes.domain.model.Solicitud;

/**
 * Vista mínima por consola.
 *
 * Puede reemplazarse por JavaFX si se desea una vista gráfica.
 */
public class ConsoleView {

    private final SolicitudController controller;

    public ConsoleView(SolicitudController controller) {
        this.controller = controller;
    }

    public void demo() {
        Estudiante estudiante = controller.registrarEstudiante(
                "Ana Torres",
                "ana.torres+" + System.currentTimeMillis() + "@universidad.cl"
        );

        Solicitud solicitud = controller.crearSolicitud(
                estudiante.getId(),
                "Certificado",
                "Solicita certificado de alumno regular"
        );

        controller.cambiarEstado(solicitud.getId(), EstadoSolicitud.EN_REVISION);

        System.out.println("Solicitud creada: " + solicitud.getId());
    }
}
