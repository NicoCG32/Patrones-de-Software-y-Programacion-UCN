package main;

import pattern.*;

public class Main {
    public static void main(String[] args) {
    Shape icon = new Shape("circulo", "azul", 10, 10);
    Shape duplicated = icon.copy().moveTo(40, 10);
    System.out.println(icon.describe());
    System.out.println(duplicated.describe());
}
}
