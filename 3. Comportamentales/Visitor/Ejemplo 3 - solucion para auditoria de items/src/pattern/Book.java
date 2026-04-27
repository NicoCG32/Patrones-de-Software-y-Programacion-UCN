package pattern;

public class Book implements Item {
    public String title() { return "Patrones GoF"; }
    public void accept(ItemVisitor visitor) { visitor.visit(this); }
}
