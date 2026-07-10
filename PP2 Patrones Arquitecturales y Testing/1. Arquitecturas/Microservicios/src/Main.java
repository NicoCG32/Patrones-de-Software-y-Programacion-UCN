public class Main {
    public static void main(String[] args) {
        CatalogoService catalogo = new CatalogoService();
        PagoService pagos = new PagoService();
        DespachoService despacho = new DespachoService();
        PedidoApp app = new PedidoApp(catalogo, pagos, despacho);

        System.out.println(app.comprar("LIB-001", 2, 18000));
    }
}

class PedidoApp {
    private final CatalogoService catalogo;
    private final PagoService pagos;
    private final DespachoService despacho;

    PedidoApp(CatalogoService catalogo, PagoService pagos, DespachoService despacho) {
        this.catalogo = catalogo;
        this.pagos = pagos;
        this.despacho = despacho;
    }

    String comprar(String sku, int cantidad, int total) {
        if (!catalogo.tieneStock(sku, cantidad)) {
            return "Pedido rechazado: stock insuficiente";
        }
        if (!pagos.autorizar(total)) {
            return "Pedido rechazado: pago no autorizado";
        }
        return despacho.agendar(sku, cantidad);
    }
}

class CatalogoService {
    boolean tieneStock(String sku, int cantidad) {
        return "LIB-001".equals(sku) && cantidad <= 5;
    }
}

class PagoService {
    boolean autorizar(int total) {
        return total > 0 && total <= 50000;
    }
}

class DespachoService {
    String agendar(String sku, int cantidad) {
        return "Despacho agendado para " + cantidad + " unidad(es) de " + sku;
    }
}
