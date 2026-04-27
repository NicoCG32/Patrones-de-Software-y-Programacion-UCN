package pattern;

public abstract class PriceDecorator implements Price {
    protected final Price wrapped;
    protected PriceDecorator(Price wrapped) { this.wrapped = wrapped; }
}
