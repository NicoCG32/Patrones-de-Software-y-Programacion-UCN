package pattern;

public class PrintVisitor implements AstVisitor {
    public void visit(NumberNode node) { System.out.println("numero " + node.value()); }
    public void visit(AddNode node) { System.out.println("suma"); node.left().accept(this); node.right().accept(this); }
}
