package pattern;

public class ShippingPrice extends PriceDecorator {
    public ShippingPrice(Price wrapped) { super(wrapped); }
    public double amount() { return wrapped.amount() + 5.0; }
}
