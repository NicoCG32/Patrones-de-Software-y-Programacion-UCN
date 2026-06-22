package main;

import static pattern.PatternImplementation.*;
public class Main {
    public static void main(String[] args) {
    ItemVisitor auditor = new AuditVisitor();
    new Book().accept(auditor);
    new SoftwareLicense().accept(auditor);
}
}
