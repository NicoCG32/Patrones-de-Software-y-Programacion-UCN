package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public interface SharedResource {
        void use(String client);
    }

    public static class ExpensiveResource implements SharedResource {
        public void use(String client) {
            System.out.println(client + " usa el recurso real");
        }
    }

    public static class SmartReferenceProxy implements SharedResource {
        private final ExpensiveResource realResource = new ExpensiveResource();
        private int accessCount;

        public void use(String client) {
            accessCount++;
            System.out.println("Acceso #" + accessCount);
            realResource.use(client);
        }
    }
}
