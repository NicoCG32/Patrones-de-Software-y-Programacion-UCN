public class Main {
    public static void main(String[] args) {
        ProductoModel model = new ProductoModel();
        HtmlView view = new HtmlView();
        ProductoController controller = new ProductoController(model, view);

        HttpRequest request = new HttpRequest("/productos/1");
        HttpResponse response = controller.obtenerProducto(request);

        System.out.println(response.status());
        System.out.println(response.body());
    }
}

class HttpRequest {
    private final String path;

    HttpRequest(String path) {
        this.path = path;
    }

    String path() {
        return path;
    }
}

class HttpResponse {
    private final int status;
    private final String body;

    HttpResponse(int status, String body) {
        this.status = status;
        this.body = body;
    }

    int status() {
        return status;
    }

    String body() {
        return body;
    }
}

class ProductoController {
    private final ProductoModel model;
    private final HtmlView view;

    ProductoController(ProductoModel model, HtmlView view) {
        this.model = model;
        this.view = view;
    }

    HttpResponse obtenerProducto(HttpRequest request) {
        if (!"/productos/1".equals(request.path())) {
            return new HttpResponse(404, "<h1>No encontrado</h1>");
        }
        Producto producto = model.buscarPorId(1);
        return new HttpResponse(200, view.render(producto));
    }
}

class ProductoModel {
    Producto buscarPorId(int id) {
        return new Producto(id, "Libro de arquitectura", 12000);
    }
}

class HtmlView {
    String render(Producto producto) {
        return "<h1>" + producto.nombre() + "</h1><p>Precio: $" + producto.precio() + "</p>";
    }
}

class Producto {
    private final int id;
    private final String nombre;
    private final int precio;

    Producto(int id, String nombre, int precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    int id() {
        return id;
    }

    String nombre() {
        return nombre;
    }

    int precio() {
        return precio;
    }
}
