package pattern;

public class OnlineOrderProcess extends OrderProcess {
    protected void charge() { System.out.println("cobro con tarjeta online"); }
    protected void deliver() { System.out.println("despacho a domicilio"); }
}
