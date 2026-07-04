package cl.ucn.solicitudes.application;

import cl.ucn.solicitudes.domain.model.Estudiante;
import cl.ucn.solicitudes.domain.repository.EstudiantePort;
import cl.ucn.solicitudes.infra.jpa.EstudianteRepository;
import java.util.Optional;

public class EstudianteService {

    private final EstudiantePort estudiantePort;

    public EstudianteService(EstudiantePort estudiantePort) {
        this.estudiantePort = estudiantePort;
    }

    public Estudiante guardar(String nombre, String correo) {
        Estudiante estudiante = new Estudiante(nombre, correo);
        return estudiantePort.guardar(estudiante);
    }

    public Optional<Estudiante> buscarPorId(Long estudianteId) {
        return estudiantePort.buscarPorId(estudianteId);
    }
}
