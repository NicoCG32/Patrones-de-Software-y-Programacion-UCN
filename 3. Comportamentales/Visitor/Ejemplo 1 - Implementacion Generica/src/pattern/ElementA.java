package pattern;

public class ElementA implements Element {
    public void accept(Visitor visitor) { visitor.visit(this); }
    public String value() { return "documento: elemento A"; }
}
