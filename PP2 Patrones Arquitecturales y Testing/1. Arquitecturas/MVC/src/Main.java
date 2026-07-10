public class Main {
    public static void main(String[] args) {
        ContadorModel model = new ContadorModel();
        ContadorView view = new ContadorView();
        ContadorController controller = new ContadorController(model, view);

        view.simularClickIncrementar(controller);
        view.simularClickIncrementar(controller);
    }
}

class ContadorModel {
    private int valor;

    void incrementar() {
        valor++;
    }

    int valor() {
        return valor;
    }
}

class ContadorView {
    void simularClickIncrementar(ContadorController controller) {
        controller.incrementarSolicitado();
    }

    void mostrarValor(int valor) {
        System.out.println("Valor actual: " + valor);
    }
}

class ContadorController {
    private final ContadorModel model;
    private final ContadorView view;

    ContadorController(ContadorModel model, ContadorView view) {
        this.model = model;
        this.view = view;
    }

    void incrementarSolicitado() {
        model.incrementar();
        view.mostrarValor(model.valor());
    }
}
