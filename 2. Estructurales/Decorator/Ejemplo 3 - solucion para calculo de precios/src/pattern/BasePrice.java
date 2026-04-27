package pattern;

public class BasePrice implements Price {
    private final double value;
    public BasePrice(double value) { this.value = value; }
    public double amount() { return value; }
}
