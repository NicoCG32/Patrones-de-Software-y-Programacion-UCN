package pattern;

public class ReportVisitor implements Visitor {
    public void visit(ElementA element) { System.out.println("procesa " + element.value()); }
    public void visit(ElementB element) { System.out.println("procesa " + element.value()); }
}
