package pattern;

public abstract class Logistics {
    public final void planDelivery(String packageId) {
        Transport transport = createTransport();
        transport.deliver(packageId);
    }
    protected abstract Transport createTransport();
}
