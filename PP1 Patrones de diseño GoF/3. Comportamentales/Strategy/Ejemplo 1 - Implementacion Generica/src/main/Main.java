package main;

import static pattern.PatternImplementation.*;
public class Main {
    public static void main(String[] args) {
    Context context = new Context(new ConservativeStrategy());
    System.out.println("descuento conservador: " + context.resolve(100));
    context.setStrategy(new AggressiveStrategy());
    System.out.println("descuento agresivo: " + context.resolve(100));
}
}
