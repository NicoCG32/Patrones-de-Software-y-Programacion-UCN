package main;

import pattern.*;

public class Main {
    public static void main(String[] args) {
    Visitor visitor = new ReportVisitor();
    Element[] elements = { new ElementA(), new ElementB() };
    for (Element element : elements) {
        element.accept(visitor);
    }
}
}
