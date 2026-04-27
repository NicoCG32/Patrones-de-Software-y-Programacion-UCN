package pattern;

public class Client {
    private final Target target;

    public Client(Target target) { this.target = target; }

    public void execute() { target.request(2590); }
}
