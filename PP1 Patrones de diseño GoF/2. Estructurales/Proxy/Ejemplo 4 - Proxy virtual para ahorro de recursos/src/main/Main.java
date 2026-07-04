package main;

import static pattern.PatternImplementation.*;

public class Main {

        public static void main(String[] args) {
            Video preview = new VirtualVideoProxy("demo-4k.mp4");
            System.out.println("Catalogo dibujado sin cargar el video real");
            preview.play();
            preview.play();
        }

}
