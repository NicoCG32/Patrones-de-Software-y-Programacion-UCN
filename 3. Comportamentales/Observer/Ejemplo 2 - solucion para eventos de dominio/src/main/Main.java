package main;

import static pattern.PatternImplementation.*;
public class Main {
    public static void main(String[] args) {
    OrderPublisher publisher = new OrderPublisher();
    publisher.subscribe(new InventoryListener());
    publisher.subscribe(new BillingListener());
    publisher.createOrder("ORD-9");
}
}
