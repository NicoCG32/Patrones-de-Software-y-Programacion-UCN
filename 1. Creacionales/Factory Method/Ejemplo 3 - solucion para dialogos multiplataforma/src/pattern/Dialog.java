package pattern;

public abstract class Dialog {
    public final void renderWindow() {
        Button button = createButton();
        button.render();
    }
    protected abstract Button createButton();
}
