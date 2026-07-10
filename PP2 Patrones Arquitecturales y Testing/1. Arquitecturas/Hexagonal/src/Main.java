import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        InventarioPort inventario = new InventarioEnMemoriaAdapter();
        PedidoService service = new PedidoService(inventario);
        PedidoController controller = new PedidoController(service);

        System.out.println(controller.crearPedido("CUADERNO", 3));
    }
}

class PedidoController {
    private final PedidoService service;

    PedidoController(PedidoService service) {
        this.service = service;
    }

    String crearPedido(String producto, int cantidad) {
        return service.reservar(producto, cantidad);
    }
}

class PedidoService {
    private final InventarioPort inventario;

    PedidoService(InventarioPort inventario) {
        this.inventario = inventario;
    }

    String reservar(String producto, int cantidad) {
        if (cantidad <= 0) {
            return "Cantidad invalida";
        }
        if (!inventario.descontar(producto, cantidad)) {
            return "No hay stock suficiente";
        }
        return "Pedido reservado: " + producto + " x" + cantidad;
    }
}

interface InventarioPort {
    boolean descontar(String producto, int cantidad);
}

class InventarioEnMemoriaAdapter implements InventarioPort {
    private final Map<String, Integer> stock = new HashMap<>();

    InventarioEnMemoriaAdapter() {
        stock.put("CUADERNO", 10);
    }

    public boolean descontar(String producto, int cantidad) {
        int disponible = stock.getOrDefault(producto, 0);
        if (disponible < cantidad) {
            return false;
        }
        stock.put(producto, disponible - cantidad);
        return true;
    }
}
