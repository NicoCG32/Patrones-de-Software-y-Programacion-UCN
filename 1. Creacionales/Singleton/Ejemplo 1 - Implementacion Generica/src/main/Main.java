package main;

import pattern.*;

public class Main {
    public static void main(String[] args) {
    SharedService.getInstance().use("modulo A");
    SharedService.getInstance().use("modulo B");
    System.out.println(SharedService.getInstance() == SharedService.getInstance());
}
}
