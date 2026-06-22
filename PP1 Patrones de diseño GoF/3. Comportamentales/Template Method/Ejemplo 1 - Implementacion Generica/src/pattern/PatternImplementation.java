package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static class ConcreteProcess extends ProcessTemplate {
        protected void executeSpecificStep() {
            System.out.println("importacion: paso variable concreto");
        }
    }

    public static abstract class ProcessTemplate {
        public final void run() {
            prepare();
            executeSpecificStep();
            validate();
            close();
        }

        protected void prepare() { System.out.println("importacion: preparar"); }
        protected abstract void executeSpecificStep();
        protected void validate() { System.out.println("importacion: validar"); }
        protected void close() { System.out.println("importacion: cerrar"); }
    }
}
