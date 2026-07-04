package cl.ucn.solicitudes.controller;

import cl.ucn.solicitudes.application.EstudianteService;
import cl.ucn.solicitudes.application.SolicitudService;
import cl.ucn.solicitudes.domain.model.EstadoSolicitud;
import cl.ucn.solicitudes.domain.model.Estudiante;
import cl.ucn.solicitudes.domain.model.Solicitud;
import cl.ucn.solicitudes.domain.repository.EstudiantePort;
import cl.ucn.solicitudes.domain.repository.SolicitudPort;
import cl.ucn.solicitudes.domain.service.NotificadorExterno;
import cl.ucn.solicitudes.domain.service.PublicadorEventosSolicitud;
import cl.ucn.solicitudes.infra.external.ServicioCorreoExterno;
import cl.ucn.solicitudes.infra.jpa.EstudianteRepository;
import cl.ucn.solicitudes.infra.jpa.SolicitudRepository;

/**
 * CONTROLADOR DEGRADADO.
 *
 * Este controlador comenzó como parte de una arquitectura MVC,
 * pero ahora accede directamente a repositorios concretos y a un servicio externo.
 *
 * Problema esperado por ArchUnit:
 * controller -> infra.jpa
 * controller -> infra.external
 */
public class SolicitudController {

    private final EstudianteService estudianteService;
    private final SolicitudService solicitudService;

    public SolicitudController (PublicadorEventosSolicitud publicadorEventos,
                                NotificadorExterno servicioExterno,
                                SolicitudPort solicitudPort,
                                EstudiantePort estudiantePort
                                ){
           solicitudService = new SolicitudService(publicadorEventos, servicioExterno, solicitudPort);
           estudianteService = new EstudianteService(estudiantePort);
    }

    /*
    private final EstudianteRepository estudianteRepository = new EstudianteRepository();
    private final SolicitudRepository solicitudRepository = new SolicitudRepository();
    private final ServicioCorreoExterno correoExterno = new ServicioCorreoExterno();
    */

    public Estudiante registrarEstudiante(String nombre, String correo) {
        return estudianteService.guardar(nombre, correo);
    }

    public Solicitud crearSolicitud(Long estudianteId, String tipo, String descripcion) {
        Estudiante estudiante = estudianteService.buscarPorId(estudianteId)
                .orElseThrow(() -> new IllegalArgumentException("Estudiante inexistente"));

        Solicitud solicitud = new Solicitud(estudiante, tipo, descripcion);
        return solicitudService.guardar(solicitud);
    }

    public Solicitud cambiarEstado(Long solicitudId, EstadoSolicitud nuevoEstado) {
        Solicitud solicitud = solicitudService.buscarPorId(solicitudId)
                .orElseThrow(() -> new IllegalArgumentException("Solicitud inexistente"));

        solicitudService.guardar(solicitud);

        solicitudService.enviarCorreo(
                solicitud.getEstudiante().getCorreo(),
                "Cambio de estado",
                "Su solicitud cambió a " + nuevoEstado
        );

        return solicitud;
    }
}
