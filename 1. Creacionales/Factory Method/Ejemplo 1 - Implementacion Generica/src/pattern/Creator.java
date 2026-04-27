package pattern;

public abstract class Creator {
    public final void process() {
        Product product = createProduct();
        System.out.println("Procesando " + product.name());
    }

    protected abstract Product createProduct();
}
