package pattern;

public class Adapter implements Target {
    private final LegacyService legacy;

    public Adapter(LegacyService legacy) { this.legacy = legacy; }

    public void request(int normalizedValue) {
        legacy.specificRequest(normalizedValue / 100.0);
    }
}
