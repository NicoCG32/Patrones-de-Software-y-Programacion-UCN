package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static abstract class Logistics {
        public final void planDelivery(String packageId) {
            Transport transport = createTransport();
            transport.deliver(packageId);
        }
        protected abstract Transport createTransport();
    }

    public static class RoadLogistics extends Logistics {
        protected Transport createTransport() { return new Truck(); }
    }

    public static class SeaLogistics extends Logistics {
        protected Transport createTransport() { return new Ship(); }
    }

    public static class Ship implements Transport {
        public void deliver(String packageId) { System.out.println("Barco entrega paquete " + packageId + " por ruta maritima"); }
    }

    public interface Transport {
        void deliver(String packageId);
    }

    public static class Truck implements Transport {
        public void deliver(String packageId) { System.out.println("Camion entrega paquete " + packageId + " por carretera"); }
    }
}
