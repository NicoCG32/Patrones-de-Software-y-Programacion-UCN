package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public interface Car {
        String specs();
    }

    public static class Catalog {
        private final VehicleFactory factory;

        public Catalog(VehicleFactory factory) { this.factory = factory; }

        public void showFamily() {
            System.out.println(factory.createScooter().specs());
            System.out.println(factory.createCar().specs());
        }
    }

    public static class ElectricCar implements Car {
        public String specs() { return "Auto electrico: cero emisiones locales"; }
    }

    public static class ElectricScooter implements Scooter {
        public String specs() { return "Scooter electrico: bateria urbana"; }
    }

    public static class ElectricVehicleFactory implements VehicleFactory {
        public Scooter createScooter() { return new ElectricScooter(); }
        public Car createCar() { return new ElectricCar(); }
    }

    public static class GasCar implements Car {
        public String specs() { return "Auto gasolina: motor combustion"; }
    }

    public static class GasScooter implements Scooter {
        public String specs() { return "Scooter gasolina: autonomia extendida"; }
    }

    public static class GasVehicleFactory implements VehicleFactory {
        public Scooter createScooter() { return new GasScooter(); }
        public Car createCar() { return new GasCar(); }
    }

    public interface Scooter {
        String specs();
    }

    public interface VehicleFactory {
        Scooter createScooter();
        Car createCar();
    }
}
