package pattern;

import java.util.ArrayList;
import java.util.List;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static class BillingListener implements DomainEventListener {
        public void onOrderCreated(String orderId) { System.out.println("Facturacion prepara cobro para " + orderId); }
    }

    public interface DomainEventListener {
        void onOrderCreated(String orderId);
    }

    public static class InventoryListener implements DomainEventListener {
        public void onOrderCreated(String orderId) { System.out.println("Inventario reserva stock para " + orderId); }
    }

    public static class OrderPublisher {
        private final List<DomainEventListener> listeners = new ArrayList<>();
        public void subscribe(DomainEventListener listener) { listeners.add(listener); }
        public void createOrder(String orderId) {
            System.out.println("Orden creada: " + orderId);
            for (DomainEventListener listener : listeners) listener.onOrderCreated(orderId);
        }
    }
}
