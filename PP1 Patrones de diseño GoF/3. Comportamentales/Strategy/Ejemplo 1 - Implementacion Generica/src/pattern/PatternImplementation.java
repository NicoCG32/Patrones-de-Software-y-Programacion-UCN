package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static class AggressiveStrategy implements Strategy {
        public double execute(double value) { return value * 0.75; }
    }

    public static class ConservativeStrategy implements Strategy {
        public double execute(double value) { return value; }
    }

    public static class Context {
        private Strategy strategy;

        public Context(Strategy strategy) { this.strategy = strategy; }
        public void setStrategy(Strategy strategy) { this.strategy = strategy; }
        public double resolve(double value) { return strategy.execute(value); }
    }

    public interface Strategy {
        double execute(double value);
    }
}
