package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public interface Button {
        void render();
    }

    public static abstract class Dialog {
        public final void renderWindow() {
            Button button = createButton();
            button.render();
        }
        protected abstract Button createButton();
    }

    public static class WebButton implements Button {
        public void render() { System.out.println("Boton HTML renderizado en navegador"); }
    }

    public static class WebDialog extends Dialog {
        protected Button createButton() { return new WebButton(); }
    }

    public static class WindowsButton implements Button {
        public void render() { System.out.println("Boton Windows con estilo nativo"); }
    }

    public static class WindowsDialog extends Dialog {
        protected Button createButton() { return new WindowsButton(); }
    }
}
