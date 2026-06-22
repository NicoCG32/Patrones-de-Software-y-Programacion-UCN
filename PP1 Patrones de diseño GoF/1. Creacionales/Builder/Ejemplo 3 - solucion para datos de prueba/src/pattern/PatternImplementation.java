package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static class TestUserBuilder {
        private String name = "usuario de prueba";
        private String role = "LECTOR";
        private boolean active = true;

        public TestUserBuilder named(String name) { this.name = name; return this; }
        public TestUserBuilder asAdmin() { this.role = "ADMIN"; return this; }
        public TestUserBuilder inactive() { this.active = false; return this; }
        public User build() { return new User(name, role, active); }
    }

    public static class User {
        private final String name;
        private final String role;
        private final boolean active;

        public User(String name, String role, boolean active) {
            this.name = name;
            this.role = role;
            this.active = active;
        }

        public String toString() { return name + " | " + role + " | activo=" + active; }
    }
}
