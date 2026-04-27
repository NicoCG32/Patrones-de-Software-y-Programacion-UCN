package pattern;

public class CheapestRoute implements RouteStrategy {
    public String calculate(String origin, String destination) { return "Ruta economica de " + origin + " a " + destination; }
}
