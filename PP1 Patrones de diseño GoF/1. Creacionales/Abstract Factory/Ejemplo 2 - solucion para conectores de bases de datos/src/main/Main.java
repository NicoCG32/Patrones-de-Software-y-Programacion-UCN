package main;

import static pattern.PatternImplementation.*;
public class Main {
    public static void main(String[] args) {
    new Repository(new PostgresDriverFactory()).findOrders();
}
}
