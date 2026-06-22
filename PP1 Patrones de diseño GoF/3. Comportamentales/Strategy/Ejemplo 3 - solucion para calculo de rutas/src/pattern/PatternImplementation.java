package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static class CheapestRoute implements RouteStrategy {
        public String calculate(String origin, String destination) { return "Ruta economica de " + origin + " a " + destination; }
    }

    public static class FastestRoute implements RouteStrategy {
        public String calculate(String origin, String destination) { return "Ruta rapida de " + origin + " a " + destination; }
    }

    public static class Navigator {
        private RouteStrategy strategy;
        public Navigator(RouteStrategy strategy) { this.strategy = strategy; }
        public void setStrategy(RouteStrategy strategy) { this.strategy = strategy; }
        public void navigate(String origin, String destination) { System.out.println(strategy.calculate(origin, destination)); }
    }

    public interface RouteStrategy {
        String calculate(String origin, String destination);
    }
}
