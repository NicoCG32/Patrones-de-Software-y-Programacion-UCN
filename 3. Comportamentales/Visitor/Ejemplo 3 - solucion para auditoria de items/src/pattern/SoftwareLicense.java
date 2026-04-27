package pattern;

public class SoftwareLicense implements Item {
    public String key() { return "LIC-2026"; }
    public void accept(ItemVisitor visitor) { visitor.visit(this); }
}
