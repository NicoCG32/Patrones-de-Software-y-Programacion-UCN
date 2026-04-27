package main;

import static pattern.PatternImplementation.*;
public class Main {
    public static void main(String[] args) {
    User defaultUser = new TestUserBuilder().build();
    User blockedAdmin = new TestUserBuilder().named("admin bloqueado").asAdmin().inactive().build();
    System.out.println(defaultUser);
    System.out.println(blockedAdmin);
}
}
