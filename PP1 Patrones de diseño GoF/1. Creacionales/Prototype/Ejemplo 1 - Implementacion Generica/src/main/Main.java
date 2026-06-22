package main;

import static pattern.PatternImplementation.*;
public class Main {
    public static void main(String[] args) {
    Template prototype = new Template("contrato base", "configuracion base");
    Template customized = prototype.copy().withVariation("variante especifica");
    System.out.println(prototype);
    System.out.println(customized);
}
}
