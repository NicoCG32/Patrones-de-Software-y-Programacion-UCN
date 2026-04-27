package pattern;

public class SeaLogistics extends Logistics {
    protected Transport createTransport() { return new Ship(); }
}
