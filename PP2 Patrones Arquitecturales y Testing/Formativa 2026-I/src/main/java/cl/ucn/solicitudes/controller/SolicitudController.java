package cl.ucn.solicitudes.controller;

import cl.ucn.solicitudes.application.SolicitudService;
import cl.ucn.solicitudes.domain.model.EstadoSolicitud;
import cl.ucn.solicitudes.domain.model.Estudiante;
import cl.ucn.solicitudes.domain.model.Solicitud;

/**
 * Controlador MVC.
 * Recibe acciones de la vista y delega los casos de uso al servicio de aplicacion.
 */
public class SolicitudController {

    private final SolicitudService solicitudService;

    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    public Estudiante registrarEstudiante(String nombre, String correo) {
        return solicitudService.registrarEstudiante(nombre, correo);
    }

    public Solicitud crearSolicitud(Long estudianteId, String tipo, String descripcion) {
        return solicitudService.crearSolicitud(estudianteId, tipo, descripcion);
    }

    public Solicitud cambiarEstado(Long solicitudId, EstadoSolicitud nuevoEstado) {
        return solicitudService.cambiarEstado(solicitudId, nuevoEstado);
    }
}
