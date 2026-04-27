package pattern;

public class RoadLogistics extends Logistics {
    protected Transport createTransport() { return new Truck(); }
}
