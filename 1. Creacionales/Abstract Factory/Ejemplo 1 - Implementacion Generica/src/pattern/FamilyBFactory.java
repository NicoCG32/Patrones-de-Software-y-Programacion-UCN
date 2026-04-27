package pattern;

public class FamilyBFactory implements FamilyFactory {
    public Primary createPrimary() { return new FamilyBPrimary(); }
    public Secondary createSecondary() { return new FamilyBSecondary(); }
}
