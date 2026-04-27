package pattern;

public class User {
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
