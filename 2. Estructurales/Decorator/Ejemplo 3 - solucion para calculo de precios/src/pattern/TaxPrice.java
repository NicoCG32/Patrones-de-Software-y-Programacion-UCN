package pattern;

public class TaxPrice extends PriceDecorator {
    public TaxPrice(Price wrapped) { super(wrapped); }
    public double amount() { return wrapped.amount() * 1.19; }
}
