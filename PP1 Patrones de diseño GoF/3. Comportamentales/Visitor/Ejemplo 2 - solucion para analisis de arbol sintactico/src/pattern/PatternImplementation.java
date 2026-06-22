package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static class AddNode implements AstNode {
        private final AstNode left;
        private final AstNode right;
        public AddNode(AstNode left, AstNode right) { this.left = left; this.right = right; }
        public AstNode left() { return left; }
        public AstNode right() { return right; }
        public void accept(AstVisitor visitor) { visitor.visit(this); }
    }

    public interface AstNode {
        void accept(AstVisitor visitor);
    }

    public interface AstVisitor {
        void visit(NumberNode node);
        void visit(AddNode node);
    }

    public static class NumberNode implements AstNode {
        private final int value;
        public NumberNode(int value) { this.value = value; }
        public int value() { return value; }
        public void accept(AstVisitor visitor) { visitor.visit(this); }
    }

    public static class PrintVisitor implements AstVisitor {
        public void visit(NumberNode node) { System.out.println("numero " + node.value()); }
        public void visit(AddNode node) { System.out.println("suma"); node.left().accept(this); node.right().accept(this); }
    }
}
