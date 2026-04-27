package pattern;

public abstract class OrderProcess {
    public final void process() {
        validate();
        charge();
        deliver();
        notifyCustomer();
    }
    protected void validate() { System.out.println("orden validada"); }
    protected abstract void charge();
    protected abstract void deliver();
    protected void notifyCustomer() { System.out.println("cliente notificado"); }
}
