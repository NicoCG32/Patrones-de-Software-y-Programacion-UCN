package pattern;

public class Navigator {
    private RouteStrategy strategy;
    public Navigator(RouteStrategy strategy) { this.strategy = strategy; }
    public void setStrategy(RouteStrategy strategy) { this.strategy = strategy; }
    public void navigate(String origin, String destination) { System.out.println(strategy.calculate(origin, destination)); }
}
