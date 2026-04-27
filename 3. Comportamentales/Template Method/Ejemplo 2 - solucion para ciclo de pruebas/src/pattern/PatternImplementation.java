package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static class LoginTest extends TestCase {
        protected void exercise() { System.out.println("ejecutar login con credenciales validas"); }
        protected void verify() { System.out.println("verificar sesion iniciada"); }
    }

    public static abstract class TestCase {
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
}
