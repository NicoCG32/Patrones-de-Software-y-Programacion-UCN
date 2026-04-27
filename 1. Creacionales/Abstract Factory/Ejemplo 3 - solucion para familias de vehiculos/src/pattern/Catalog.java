package pattern;

public class Catalog {
    private final VehicleFactory factory;

    public Catalog(VehicleFactory factory) { this.factory = factory; }

    public void showFamily() {
        System.out.println(factory.createScooter().specs());
        System.out.println(factory.createCar().specs());
    }
}
