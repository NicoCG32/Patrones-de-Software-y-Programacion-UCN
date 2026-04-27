package pattern;

public class Facade {
    private final StepA a = new StepA();
    private final StepB b = new StepB();
    private final StepC c = new StepC();

    public void runProcess() {
        if (!a.check()) throw new IllegalStateException("No se puede continuar");
        b.execute();
        c.finish();
    }
}
