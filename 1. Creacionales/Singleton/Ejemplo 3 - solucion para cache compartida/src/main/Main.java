package main;

import static pattern.PatternImplementation.*;
public class Main {
    public static void main(String[] args) {
    System.out.println(MetadataCache.getInstance().find("producto"));
    System.out.println(MetadataCache.getInstance().find("producto"));
}
}
