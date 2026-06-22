package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static class Proxy implements Subject {
        private RealSubject real;

        public void request() {
            if (real == null) real = new RealSubject();
            real.request();
        }
    }

    public static class RealSubject implements Subject {
        public RealSubject() { System.out.println("Creando recurso costoso: imagen pesada"); }
        public void request() { System.out.println("Usando recurso real: imagen pesada"); }
    }

    public interface Subject {
        void request();
    }
}
