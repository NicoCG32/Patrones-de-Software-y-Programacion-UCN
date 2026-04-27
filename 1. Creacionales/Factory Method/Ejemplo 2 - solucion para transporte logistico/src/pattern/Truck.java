package pattern;

public class Truck implements Transport {
    public void deliver(String packageId) { System.out.println("Camion entrega paquete " + packageId + " por carretera"); }
}
