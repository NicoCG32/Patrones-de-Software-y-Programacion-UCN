package main;

import static pattern.PatternImplementation.*;
public class Main {
    public static void main(String[] args) {
    QueryTemplate base = new QueryTemplate("orders", "status = 'OPEN'");
    System.out.println(base.sql());
    System.out.println(base.copy().withFilter("status = 'CLOSED'").sql());
}
}
