package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static class Adapter implements Target {
        private final LegacyService legacy;

        public Adapter(LegacyService legacy) { this.legacy = legacy; }

        public void request(int normalizedValue) {
            legacy.specificRequest(normalizedValue / 100.0);
        }
    }

    public static class Client {
        private final Target target;

        public Client(Target target) { this.target = target; }

        public void execute() { target.request(2590); }
    }

    public static class LegacyService {
        public void specificRequest(double externalValue) {
            System.out.println("pago legado recibe " + externalValue);
        }
    }

    public interface Target {
        void request(int normalizedValue);
    }
}
