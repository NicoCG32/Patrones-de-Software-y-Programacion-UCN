package main;

import static pattern.PatternImplementation.*;

public class Main {

        public static void main(String[] args) {
            SharedResource resource = new SmartReferenceProxy();
            resource.use("modulo A");
            resource.use("modulo B");
        }

}
