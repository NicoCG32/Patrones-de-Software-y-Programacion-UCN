package cl.ucn.solicitudes;

import cl.ucn.solicitudes.infra.jpa.JpaUtil;
import cl.ucn.solicitudes.view.SolicitudJavaFxView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Punto de entrada de la aplicación.
 *
 * Este Main abre una vista JavaFX para evidenciar el comportamiento MVC:
 *
 * View -> Controller -> Model / Persistence
 *
 * La arquitectura está degradada de forma intencional porque el controlador
 * todavía depende directamente de infraestructura.
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Config cfg = new Config();
        SolicitudJavaFxView view = new SolicitudJavaFxView(cfg.getController());
        view.mostrar(stage);
    }

    @Override
    public void stop() {
        JpaUtil.cerrar();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
