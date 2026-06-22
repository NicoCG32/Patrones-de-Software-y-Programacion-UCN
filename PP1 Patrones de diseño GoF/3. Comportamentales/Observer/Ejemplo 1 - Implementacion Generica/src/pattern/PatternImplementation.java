package pattern;

import java.util.ArrayList;
import java.util.List;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static class ConsoleObserver implements Observer {
        private final String name;

        public ConsoleObserver(String name) { this.name = name; }

        public void update(String event) {
            System.out.println(name + " recibe " + event);
        }
    }

    public interface Observer {
        void update(String event);
    }

    public static class Subject {
        private final List<Observer> observers = new ArrayList<>();

        public void attach(Observer observer) { observers.add(observer); }

        public void change(String value) {
            for (Observer observer : observers) {
                observer.update("catalogo: " + value);
            }
        }
    }
}
