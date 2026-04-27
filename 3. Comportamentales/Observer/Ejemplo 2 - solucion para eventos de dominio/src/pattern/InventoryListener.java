package pattern;

public class InventoryListener implements DomainEventListener {
    public void onOrderCreated(String orderId) { System.out.println("Inventario reserva stock para " + orderId); }
}
