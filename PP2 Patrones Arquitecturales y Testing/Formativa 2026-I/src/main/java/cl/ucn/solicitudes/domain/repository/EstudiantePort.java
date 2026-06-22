package cl.ucn.solicitudes.domain.repository;

import cl.ucn.solicitudes.domain.model.Estudiante;

import java.util.Optional;

public interface EstudiantePort {

    Estudiante guardar(Estudiante estudiante);

    Optional<Estudiante> buscarPorId(Long id);
}
