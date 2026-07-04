package cl.ucn.solicitudes.domain.repository;

import java.util.*;
import cl.ucn.solicitudes.domain.model.Estudiante;

public interface EstudiantePort {
    Estudiante guardar(Estudiante estudiante);

    Optional<Estudiante> buscarPorId(Long estudianteId);
}
