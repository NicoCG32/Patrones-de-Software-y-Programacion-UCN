package main;

import static pattern.PatternImplementation.*;
public class Main {
    public static void main(String[] args) {
    RealtimeDashboard dashboard = new RealtimeDashboard();
    dashboard.attach(new ChartWidget());
    dashboard.attach(new CounterWidget());
    dashboard.setActiveUsers(128);
}
}
