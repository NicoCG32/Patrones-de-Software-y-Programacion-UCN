package pattern;

public class BillingListener implements DomainEventListener {
    public void onOrderCreated(String orderId) { System.out.println("Facturacion prepara cobro para " + orderId); }
}
