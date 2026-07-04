package main;

import static pattern.PatternImplementation.*;
public class Main {
    public static void main(String[] args) {
    Logistics logistics = new RoadLogistics();
    logistics.planDelivery("PKG-42");
}
}
