package main;

import static pattern.PatternImplementation.*;
public class Main {
    public static void main(String[] args) {
    DataStream stream = new EncryptedStream(new BufferedStream(new FileStream()));
    System.out.println(stream.read());
}
}
