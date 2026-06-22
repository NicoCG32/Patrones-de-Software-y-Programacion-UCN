package cl.ucn.solicitudes.domain.service;

import cl.ucn.solicitudes.application.EventoCambioEstadoSolicitud;

public interface PublicadorEventosSolicitud {

    void publicar(EventoCambioEstadoSolicitud evento);
}
