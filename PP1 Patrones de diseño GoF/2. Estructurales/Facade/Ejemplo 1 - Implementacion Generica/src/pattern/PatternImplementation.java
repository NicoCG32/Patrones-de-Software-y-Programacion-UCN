package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static class Facade {
        private final StepA a = new StepA();
        private final StepB b = new StepB();
        private final StepC c = new StepC();

        public void runProcess() {
            if (!a.check()) throw new IllegalStateException("No se puede continuar");
            b.execute();
            c.finish();
        }
    }

    public static class StepA {
        public boolean check() {
            System.out.println("orden de compra: verificacion");
            return true;
        }
    }

    public static class StepB {
        public void execute() { System.out.println("orden de compra: ejecucion principal"); }
    }

    public static class StepC {
        public void finish() { System.out.println("orden de compra: cierre"); }
    }
}
