package pattern;

public class Proxy implements Subject {
    private RealSubject real;

    public void request() {
        if (real == null) real = new RealSubject();
        real.request();
    }
}
