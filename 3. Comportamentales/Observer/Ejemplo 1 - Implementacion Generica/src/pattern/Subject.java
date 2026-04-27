package pattern;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private final List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) { observers.add(observer); }

    public void change(String value) {
        for (Observer observer : observers) {
            observer.update("catalogo: " + value);
        }
    }
}
