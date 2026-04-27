package pattern;

public class ChartWidget implements MetricObserver {
    public void update(int activeUsers) { System.out.println("Grafico actualiza usuarios=" + activeUsers); }
}
