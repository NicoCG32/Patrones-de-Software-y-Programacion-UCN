package pattern;

public class WindowsDialog extends Dialog {
    protected Button createButton() { return new WindowsButton(); }
}
