package pattern;

import java.util.ArrayList;
import java.util.List;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static class ChartWidget implements MetricObserver {
        public void update(int activeUsers) { System.out.println("Grafico actualiza usuarios=" + activeUsers); }
    }

    public static class CounterWidget implements MetricObserver {
        public void update(int activeUsers) { System.out.println("Contador muestra " + activeUsers); }
    }

    public interface MetricObserver {
        void update(int activeUsers);
    }

    public static class RealtimeDashboard {
        private final List<MetricObserver> observers = new ArrayList<>();
        public void attach(MetricObserver observer) { observers.add(observer); }
        public void setActiveUsers(int activeUsers) {
            for (MetricObserver observer : observers) observer.update(activeUsers);
        }
    }
}
