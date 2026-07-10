public class Main {
    public static void main(String[] args) {
        Backend backend = new Backend();
        Frontend frontend = new Frontend(backend);

        frontend.mostrarPromedio("Ana", new double[] {6.0, 5.5, 6.5});
    }
}

class Frontend {
    private final Backend backend;

    Frontend(Backend backend) {
        this.backend = backend;
    }

    void mostrarPromedio(String estudiante, double[] notas) {
        String respuesta = backend.calcularPromedio(estudiante, notas);
        System.out.println("Vista: " + respuesta);
    }
}

class Backend {
    String calcularPromedio(String estudiante, double[] notas) {
        if (notas.length == 0) {
            return estudiante + " no tiene notas registradas";
        }

        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }

        double promedio = suma / notas.length;
        return estudiante + " tiene promedio " + promedio;
    }
}
