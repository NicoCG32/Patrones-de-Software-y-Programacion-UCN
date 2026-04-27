package main;

import pattern.*;

public class Main {
    public static void main(String[] args) {
    Subject subject = new Subject();
    subject.attach(new ConsoleObserver("observador A"));
    subject.attach(new ConsoleObserver("observador B"));
    subject.change("estado modificado");
}
}
