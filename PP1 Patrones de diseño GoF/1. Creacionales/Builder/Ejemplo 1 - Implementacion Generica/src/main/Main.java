package main;

import static pattern.PatternImplementation.*;
public class Main {
    public static void main(String[] args) {
    Product product = new Director().construct(new ConcreteBuilder());
    System.out.println(product);
}
}
