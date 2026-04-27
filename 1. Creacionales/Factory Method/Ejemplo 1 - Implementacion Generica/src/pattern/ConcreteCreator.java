package pattern;

public class ConcreteCreator extends Creator {
    protected Product createProduct() {
        return new ConcreteProduct();
    }
}
