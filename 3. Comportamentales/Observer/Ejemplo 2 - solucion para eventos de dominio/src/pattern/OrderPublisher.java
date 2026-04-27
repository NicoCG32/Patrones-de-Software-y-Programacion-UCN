package pattern;

import java.util.ArrayList;
import java.util.List;

public class OrderPublisher {
    private final List<DomainEventListener> listeners = new ArrayList<>();
    public void subscribe(DomainEventListener listener) { listeners.add(listener); }
    public void createOrder(String orderId) {
        System.out.println("Orden creada: " + orderId);
        for (DomainEventListener listener : listeners) listener.onOrderCreated(orderId);
    }
}
