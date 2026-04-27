package pattern;

public final class PatternImplementation {
    private PatternImplementation() { }

    public static class OnlineOrderProcess extends OrderProcess {
        protected void charge() { System.out.println("cobro con tarjeta online"); }
        protected void deliver() { System.out.println("despacho a domicilio"); }
    }

    public static abstract class OrderProcess {
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
}
