package main;

import pattern.*;

public class Main {
    public static void main(String[] args) {
    DistanceCalculator calculator = new KilometerAdapter(new MilesLibrary());
    System.out.printf("%.2f km%n", calculator.distanceInKilometers(10, 25));
}
}
