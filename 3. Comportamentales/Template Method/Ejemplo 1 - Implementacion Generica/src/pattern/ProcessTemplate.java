package pattern;

public abstract class ProcessTemplate {
    public final void run() {
        prepare();
        executeSpecificStep();
        validate();
        close();
    }

    protected void prepare() { System.out.println("importacion: preparar"); }
    protected abstract void executeSpecificStep();
    protected void validate() { System.out.println("importacion: validar"); }
    protected void close() { System.out.println("importacion: cerrar"); }
}
