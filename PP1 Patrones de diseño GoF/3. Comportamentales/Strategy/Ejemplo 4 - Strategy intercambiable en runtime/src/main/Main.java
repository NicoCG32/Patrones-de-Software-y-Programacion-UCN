package main;

import static pattern.PatternImplementation.*;

public class Main {

        public static void main(String[] args) {
            ImageEditor editor = new ImageEditor(new GrayscaleFilter());
            System.out.println(editor.render("foto.png"));

            editor.setFilter(new ContrastFilter());
            System.out.println(editor.render("foto.png"));
        }

}
