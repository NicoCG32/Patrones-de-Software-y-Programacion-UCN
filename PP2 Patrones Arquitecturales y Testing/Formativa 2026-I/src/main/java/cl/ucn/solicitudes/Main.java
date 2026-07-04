package cl.ucn.solicitudes;

import cl.ucn.solicitudes.application.SolicitudService;
import cl.ucn.solicitudes.controller.SolicitudController;
import cl.ucn.solicitudes.domain.repository.EstudiantePort;
import cl.ucn.solicitudes.domain.repository.SolicitudPort;
import cl.ucn.solicitudes.domain.service.NotificadorExterno;
import cl.ucn.solicitudes.domain.service.PublicadorEventosSolicitud;
import cl.ucn.solicitudes.infra.external.ServicioCorreoExterno;
import cl.ucn.solicitudes.infra.jpa.EstudianteRepository;
import cl.ucn.solicitudes.infra.jpa.HistorialEventoRepository;
import cl.ucn.solicitudes.infra.jpa.JpaUtil;
import cl.ucn.solicitudes.infra.jpa.SolicitudRepository;
import cl.ucn.solicitudes.infra.messaging.HistorialEventosVerticle;
import cl.ucn.solicitudes.infra.messaging.VertxPublicadorEventosSolicitud;
import cl.ucn.solicitudes.view.SolicitudJavaFxView;
import io.vertx.core.Vertx;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Punto de entrada de la aplicacion.
 *
 * Flujo principal:
 * View -> Controller -> Application -> Domain -> Infrastructure
 */
public class Main extends Application {

    private Vertx vertx;

    @Override
    public void start(Stage stage) {
        vertx = Vertx.vertx();
        vertx.deployVerticle(new HistorialEventosVerticle(new HistorialEventoRepository()));

        EstudiantePort estudiantePort = new EstudianteRepository();
        SolicitudPort solicitudPort = new SolicitudRepository();
        PublicadorEventosSolicitud publicador = new VertxPublicadorEventosSolicitud(vertx);
        NotificadorExterno notificador = new ServicioCorreoExterno();

        SolicitudService service = new SolicitudService(
                estudiantePort,
                solicitudPort,
                publicador,
                notificador
        );
        SolicitudController controller = new SolicitudController(service);
        SolicitudJavaFxView view = new SolicitudJavaFxView(controller);

        view.mostrar(stage);
    }

    @Override
    public void stop() {
        if (vertx != null) {
            vertx.close();
        }
        JpaUtil.cerrar();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
