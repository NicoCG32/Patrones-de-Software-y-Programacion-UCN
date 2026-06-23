package cl.ucn.solicitudes.domain.repository;

import cl.ucn.solicitudes.domain.model.Solicitud;

import java.util.Optional;

/**
 * Puerto de persistencia esperado para la refactorización.
 *
 * Está definido, pero el sistema degradado todavía no lo usa en todas partes.
 */
public interface SolicitudPort {

    Solicitud guardar(Solicitud solicitud);

    Optional<Solicitud> buscarPorId(Long id);
}
