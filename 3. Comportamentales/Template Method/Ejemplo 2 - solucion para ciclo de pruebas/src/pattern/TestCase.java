package pattern;

public abstract class TestCase {
    public final void run() {
        setUp();
        exercise();
        verify();
        tearDown();
    }
    protected void setUp() { System.out.println("preparar fixture"); }
    protected abstract void exercise();
    protected abstract void verify();
    protected void tearDown() { System.out.println("limpiar fixture"); }
}
