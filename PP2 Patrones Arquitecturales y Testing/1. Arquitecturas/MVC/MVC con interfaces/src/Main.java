public class Main {
    public static void main(String[] args) {
        IContadorModel model = new ContadorModel();
        IContadorView view = new ConsoleContadorView();
        IContadorController controller = new ContadorController(model, view);

        controller.incrementar();
        controller.incrementar();
    }
}

interface IContadorModel {
    void incrementar();
    int valor();
}

interface IContadorView {
    void mostrar(int valor);
}

interface IContadorController {
    void incrementar();
}

class ContadorModel implements IContadorModel {
    private int valor;

    public void incrementar() {
        valor++;
    }

    public int valor() {
        return valor;
    }
}

class ConsoleContadorView implements IContadorView {
    public void mostrar(int valor) {
        System.out.println("Valor desde vista: " + valor);
    }
}

class ContadorController implements IContadorController {
    private final IContadorModel model;
    private final IContadorView view;

    ContadorController(IContadorModel model, IContadorView view) {
        this.model = model;
        this.view = view;
    }

    public void incrementar() {
        model.incrementar();
        view.mostrar(model.valor());
    }
}
