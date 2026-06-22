package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static class Client {
        private final Primary primary;
        private final Secondary secondary;

        public Client(FamilyFactory factory) {
            primary = factory.createPrimary();
            secondary = factory.createSecondary();
        }

        public void run() {
            System.out.println(primary.describe());
            System.out.println(secondary.describe());
        }
    }

    public static class FamilyAFactory implements FamilyFactory {
        public Primary createPrimary() { return new FamilyAPrimary(); }
        public Secondary createSecondary() { return new FamilyASecondary(); }
    }

    public static class FamilyAPrimary implements Primary {
        public String describe() { return "tema grafico familia A - producto principal"; }
    }

    public static class FamilyASecondary implements Secondary {
        public String describe() { return "tema grafico familia A - producto secundario"; }
    }

    public static class FamilyBFactory implements FamilyFactory {
        public Primary createPrimary() { return new FamilyBPrimary(); }
        public Secondary createSecondary() { return new FamilyBSecondary(); }
    }

    public static class FamilyBPrimary implements Primary {
        public String describe() { return "tema grafico familia B - producto principal"; }
    }

    public static class FamilyBSecondary implements Secondary {
        public String describe() { return "tema grafico familia B - producto secundario"; }
    }

    public interface FamilyFactory {
        Primary createPrimary();
        Secondary createSecondary();
    }

    public interface Primary {
        String describe();
    }

    public interface Secondary {
        String describe();
    }
}
