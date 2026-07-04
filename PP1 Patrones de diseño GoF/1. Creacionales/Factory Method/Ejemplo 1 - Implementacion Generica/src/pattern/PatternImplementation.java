package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static class ConcreteCreator extends Creator {
        protected Product createProduct() {
            return new ConcreteProduct();
        }
    }

    public static class ConcreteProduct implements Product {
        public String name() { return "documento PDF"; }
    }

    public static abstract class Creator {
        public final void process() {
            Product product = createProduct();
            System.out.println("Procesando " + product.name());
        }

        protected abstract Product createProduct();
    }

    public interface Product {
        String name();
    }
}
