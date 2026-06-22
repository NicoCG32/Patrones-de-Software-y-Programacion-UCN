package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static class BasePrice implements Price {
        private final double value;
        public BasePrice(double value) { this.value = value; }
        public double amount() { return value; }
    }

    public interface Price {
        double amount();
    }

    public static abstract class PriceDecorator implements Price {
        protected final Price wrapped;
        protected PriceDecorator(Price wrapped) { this.wrapped = wrapped; }
    }

    public static class ShippingPrice extends PriceDecorator {
        public ShippingPrice(Price wrapped) { super(wrapped); }
        public double amount() { return wrapped.amount() + 5.0; }
    }

    public static class TaxPrice extends PriceDecorator {
        public TaxPrice(Price wrapped) { super(wrapped); }
        public double amount() { return wrapped.amount() * 1.19; }
    }
}
