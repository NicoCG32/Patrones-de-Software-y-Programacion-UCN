import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SalidaLayer salida = new SalidaLayer();
        PersistenciaLayer persistencia = new PersistenciaLayer(salida);
        DominioLayer dominio = new DominioLayer(persistencia);
        AplicacionLayer aplicacion = new AplicacionLayer(dominio);
        ValidacionLayer validacion = new ValidacionLayer(aplicacion);
        EntradaLayer entrada = new EntradaLayer(validacion);

        entrada.recibir("ana@universidad.cl");
    }
}

class EntradaLayer {
    private final ValidacionLayer siguiente;

    EntradaLayer(ValidacionLayer siguiente) {
        this.siguiente = siguiente;
    }

    void recibir(String correo) {
        siguiente.validar(correo);
    }
}

class ValidacionLayer {
    private final AplicacionLayer siguiente;

    ValidacionLayer(AplicacionLayer siguiente) {
        this.siguiente = siguiente;
    }

    void validar(String correo) {
        if (correo == null || !correo.contains("@")) {
            throw new IllegalArgumentException("Correo invalido");
        }
        siguiente.inscribir(correo);
    }
}

class AplicacionLayer {
    private final DominioLayer siguiente;

    AplicacionLayer(DominioLayer siguiente) {
        this.siguiente = siguiente;
    }

    void inscribir(String correo) {
        siguiente.crearInscripcion(correo);
    }
}

class DominioLayer {
    private final PersistenciaLayer siguiente;

    DominioLayer(PersistenciaLayer siguiente) {
        this.siguiente = siguiente;
    }

    void crearInscripcion(String correo) {
        Inscripcion inscripcion = new Inscripcion(correo, "PENDIENTE");
        siguiente.guardar(inscripcion);
    }
}

class PersistenciaLayer {
    private final List<Inscripcion> datos = new ArrayList<>();
    private final SalidaLayer siguiente;

    PersistenciaLayer(SalidaLayer siguiente) {
        this.siguiente = siguiente;
    }

    void guardar(Inscripcion inscripcion) {
        datos.add(inscripcion);
        siguiente.mostrar("Inscripcion guardada para " + inscripcion.correo());
    }
}

class SalidaLayer {
    void mostrar(String mensaje) {
        System.out.println(mensaje);
    }
}

class Inscripcion {
    private final String correo;
    private final String estado;

    Inscripcion(String correo, String estado) {
        this.correo = correo;
        this.estado = estado;
    }

    String correo() {
        return correo;
    }

    String estado() {
        return estado;
    }
}
