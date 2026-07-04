package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public interface Prototype<T> {
        T copy();
    }

    public static class Template implements Prototype<Template> {
        private final String base;
        private final String variation;

        public Template(String base, String variation) {
            this.base = base;
            this.variation = variation;
        }

        public Template copy() { return new Template(base, variation); }
        public Template withVariation(String newVariation) { return new Template(base, newVariation); }
        public String toString() { return base + " -> " + variation; }
    }
}
