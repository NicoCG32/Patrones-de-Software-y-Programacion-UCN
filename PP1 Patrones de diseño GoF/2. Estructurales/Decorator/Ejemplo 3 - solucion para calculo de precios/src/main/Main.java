package main;

import static pattern.PatternImplementation.*;
public class Main {
    public static void main(String[] args) {
    Price price = new ShippingPrice(new TaxPrice(new BasePrice(100.0)));
    System.out.println(price.amount());
}
}
