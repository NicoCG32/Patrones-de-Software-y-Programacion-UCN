package pattern;

public class CounterWidget implements MetricObserver {
    public void update(int activeUsers) { System.out.println("Contador muestra " + activeUsers); }
}
