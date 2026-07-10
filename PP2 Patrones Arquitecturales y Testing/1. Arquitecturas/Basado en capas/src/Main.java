import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TareaRepository repository = new TareaRepository();
        TareaService service = new TareaService(repository);
        TareaController controller = new TareaController(service);

        controller.crearTarea("Preparar pauta de estudio");
        controller.crearTarea("Revisar dependencias entre capas");
        controller.mostrarTareas();
    }
}

class TareaController {
    private final TareaService service;

    TareaController(TareaService service) {
        this.service = service;
    }

    void crearTarea(String descripcion) {
        service.registrar(descripcion);
    }

    void mostrarTareas() {
        for (Tarea tarea : service.listar()) {
            System.out.println(tarea.descripcion());
        }
    }
}

class TareaService {
    private final TareaRepository repository;

    TareaService(TareaRepository repository) {
        this.repository = repository;
    }

    void registrar(String descripcion) {
        if (descripcion == null || descripcion.isBlank()) {
            throw new IllegalArgumentException("La descripcion es obligatoria");
        }
        repository.guardar(new Tarea(descripcion.trim()));
    }

    List<Tarea> listar() {
        return repository.listar();
    }
}

class TareaRepository {
    private final List<Tarea> tareas = new ArrayList<>();

    void guardar(Tarea tarea) {
        tareas.add(tarea);
    }

    List<Tarea> listar() {
        return new ArrayList<>(tareas);
    }
}

class Tarea {
    private final String descripcion;

    Tarea(String descripcion) {
        this.descripcion = descripcion;
    }

    String descripcion() {
        return descripcion;
    }
}
