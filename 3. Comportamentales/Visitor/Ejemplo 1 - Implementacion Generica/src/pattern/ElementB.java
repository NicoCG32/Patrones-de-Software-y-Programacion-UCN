package pattern;

public class ElementB implements Element {
    public void accept(Visitor visitor) { visitor.visit(this); }
    public String value() { return "documento: elemento B"; }
}
