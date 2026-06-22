package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public interface Element {
        void accept(Visitor visitor);
    }

    public static class ElementA implements Element {
        public void accept(Visitor visitor) { visitor.visit(this); }
        public String value() { return "documento: elemento A"; }
    }

    public static class ElementB implements Element {
        public void accept(Visitor visitor) { visitor.visit(this); }
        public String value() { return "documento: elemento B"; }
    }

    public static class ReportVisitor implements Visitor {
        public void visit(ElementA element) { System.out.println("procesa " + element.value()); }
        public void visit(ElementB element) { System.out.println("procesa " + element.value()); }
    }

    public interface Visitor {
        void visit(ElementA element);
        void visit(ElementB element);
    }
}
