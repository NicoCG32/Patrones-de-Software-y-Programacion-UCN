package main;

import static pattern.PatternImplementation.*;
public class Main {
    public static void main(String[] args) {
        PurchaseOrder order = PurchaseOrder.builder("cliente-42")
            .addItem("SKU-100")
            .addItem("SKU-200")
            .discount(0.15)
            .shippingMethod("domicilio")
            .build();

        System.out.println(order.describe());
    }
}
