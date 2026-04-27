package pattern;

public class GasVehicleFactory implements VehicleFactory {
    public Scooter createScooter() { return new GasScooter(); }
    public Car createCar() { return new GasCar(); }
}
