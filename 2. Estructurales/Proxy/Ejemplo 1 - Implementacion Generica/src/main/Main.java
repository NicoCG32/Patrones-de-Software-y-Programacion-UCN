package main;

import pattern.*;

public class Main {
    public static void main(String[] args) {
    Subject subject = new Proxy();
    subject.request();
    subject.request();
}
}
