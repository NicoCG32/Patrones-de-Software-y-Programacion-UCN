package main;

import static pattern.PatternImplementation.*;
public class Main {
    public static void main(String[] args) {
    Document document = new ProtectedDocumentProxy();
    document.open("LECTOR");
    document.open("ADMIN");
}
}
