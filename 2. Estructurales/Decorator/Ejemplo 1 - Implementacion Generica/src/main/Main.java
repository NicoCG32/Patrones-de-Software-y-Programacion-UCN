package main;

import pattern.*;

public class Main {
    public static void main(String[] args) {
    Component component = new SecondResponsibility(new FirstResponsibility(new BaseComponent()));
    System.out.println(component.operation());
}
}
