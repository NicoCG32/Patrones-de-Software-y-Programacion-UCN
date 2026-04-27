package pattern;

import java.util.ArrayList;
import java.util.List;

public class RealtimeDashboard {
    private final List<MetricObserver> observers = new ArrayList<>();
    public void attach(MetricObserver observer) { observers.add(observer); }
    public void setActiveUsers(int activeUsers) {
        for (MetricObserver observer : observers) observer.update(activeUsers);
    }
}
