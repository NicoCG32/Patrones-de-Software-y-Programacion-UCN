package pattern;

public class Ship implements Transport {
    public void deliver(String packageId) { System.out.println("Barco entrega paquete " + packageId + " por ruta maritima"); }
}
