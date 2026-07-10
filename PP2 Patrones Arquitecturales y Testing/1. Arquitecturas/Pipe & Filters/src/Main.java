import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Pipeline pipeline = new Pipeline();
        pipeline.agregar(new LimpiarFiltro());
        pipeline.agregar(new MinusculasFiltro());
        pipeline.agregar(new SepararPalabrasFiltro());

        String resultado = pipeline.ejecutar("  Arquitectura   PIPE   AND   FILTERS  ");
        System.out.println(resultado);
    }
}

interface Filtro {
    String aplicar(String entrada);
}

class Pipeline {
    private final List<Filtro> filtros = new ArrayList<>();

    void agregar(Filtro filtro) {
        filtros.add(filtro);
    }

    String ejecutar(String entrada) {
        String actual = entrada;
        for (Filtro filtro : filtros) {
            actual = filtro.aplicar(actual);
        }
        return actual;
    }
}

class LimpiarFiltro implements Filtro {
    public String aplicar(String entrada) {
        return entrada.trim().replaceAll("\\s+", " ");
    }
}

class MinusculasFiltro implements Filtro {
    public String aplicar(String entrada) {
        return entrada.toLowerCase();
    }
}

class SepararPalabrasFiltro implements Filtro {
    public String aplicar(String entrada) {
        return entrada.replace(" ", System.lineSeparator());
    }
}
