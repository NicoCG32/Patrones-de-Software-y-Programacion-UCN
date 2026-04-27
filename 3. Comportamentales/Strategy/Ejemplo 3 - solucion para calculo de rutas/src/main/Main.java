package main;

import static pattern.PatternImplementation.*;
public class Main {
    public static void main(String[] args) {
    Navigator navigator = new Navigator(new FastestRoute());
    navigator.navigate("Santiago", "Valparaiso");
    navigator.setStrategy(new CheapestRoute());
    navigator.navigate("Santiago", "Valparaiso");
}
}
