package pattern;

public interface DomainEventListener {
    void onOrderCreated(String orderId);
}
