package pattern;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) { this.strategy = strategy; }
    public void setStrategy(Strategy strategy) { this.strategy = strategy; }
    public double resolve(double value) { return strategy.execute(value); }
}
