package pattern;

public class FamilyAFactory implements FamilyFactory {
    public Primary createPrimary() { return new FamilyAPrimary(); }
    public Secondary createSecondary() { return new FamilyASecondary(); }
}
