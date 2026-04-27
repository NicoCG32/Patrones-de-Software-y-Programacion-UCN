package main;

import pattern.*;

public class Main {
    public static void main(String[] args) {
    AstNode expression = new AddNode(new NumberNode(2), new NumberNode(3));
    expression.accept(new PrintVisitor());
}
}
