package pattern;

public class TestUserBuilder {
    private String name = "usuario de prueba";
    private String role = "LECTOR";
    private boolean active = true;

    public TestUserBuilder named(String name) { this.name = name; return this; }
    public TestUserBuilder asAdmin() { this.role = "ADMIN"; return this; }
    public TestUserBuilder inactive() { this.active = false; return this; }
    public User build() { return new User(name, role, active); }
}
