package pattern;

public class AggressiveStrategy implements Strategy {
    public double execute(double value) { return value * 0.75; }
}
