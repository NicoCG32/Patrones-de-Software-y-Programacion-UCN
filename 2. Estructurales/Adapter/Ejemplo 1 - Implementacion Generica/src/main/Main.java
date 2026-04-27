package main;

import pattern.*;

public class Main {
    public static void main(String[] args) {
    Target target = new Adapter(new LegacyService());
    new Client(target).execute();
}
}
