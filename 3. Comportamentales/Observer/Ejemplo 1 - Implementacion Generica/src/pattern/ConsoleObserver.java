package pattern;

public class ConsoleObserver implements Observer {
    private final String name;

    public ConsoleObserver(String name) { this.name = name; }

    public void update(String event) {
        System.out.println(name + " recibe " + event);
    }
}
