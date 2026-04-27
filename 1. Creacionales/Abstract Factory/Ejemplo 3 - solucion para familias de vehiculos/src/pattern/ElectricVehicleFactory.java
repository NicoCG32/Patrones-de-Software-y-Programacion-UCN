package pattern;

public class ElectricVehicleFactory implements VehicleFactory {
    public Scooter createScooter() { return new ElectricScooter(); }
    public Car createCar() { return new ElectricCar(); }
}
