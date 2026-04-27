package main;

import pattern.*;

public class Main {
    public static void main(String[] args) {
    System.out.println(MetadataCache.getInstance().find("producto"));
    System.out.println(MetadataCache.getInstance().find("producto"));
}
}
