import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LibroRepository repository = new LibroRepository();
        LibroService service = new LibroService(repository);
        LibroView view = new LibroView(service);

        view.registrar("Patrones de software");
        view.registrar("Arquitectura limpia");
        view.mostrarCatalogo();
    }
}

class LibroView {
    private final LibroService service;

    LibroView(LibroService service) {
        this.service = service;
    }

    void registrar(String titulo) {
        service.registrarLibro(titulo);
    }

    void mostrarCatalogo() {
        for (String titulo : service.listarTitulos()) {
            System.out.println("Libro: " + titulo);
        }
    }
}

class LibroService {
    private final LibroRepository repository;

    LibroService(LibroRepository repository) {
        this.repository = repository;
    }

    void registrarLibro(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("El titulo es obligatorio");
        }
        repository.guardar(titulo.trim());
    }

    List<String> listarTitulos() {
        return repository.listar();
    }
}

class LibroRepository {
    private final List<String> titulos = new ArrayList<>();

    void guardar(String titulo) {
        titulos.add(titulo);
    }

    List<String> listar() {
        return new ArrayList<>(titulos);
    }
}
