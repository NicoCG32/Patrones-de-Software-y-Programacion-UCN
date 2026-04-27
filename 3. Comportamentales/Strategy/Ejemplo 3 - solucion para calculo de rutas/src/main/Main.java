package main;

import pattern.*;

public class Main {
    public static void main(String[] args) {
    Navigator navigator = new Navigator(new FastestRoute());
    navigator.navigate("Santiago", "Valparaiso");
    navigator.setStrategy(new CheapestRoute());
    navigator.navigate("Santiago", "Valparaiso");
}
}
