package main;

import static pattern.PatternImplementation.*;
public class Main {
    public static void main(String[] args) {
    Subject subject = new Proxy();
    subject.request();
    subject.request();
}
}
