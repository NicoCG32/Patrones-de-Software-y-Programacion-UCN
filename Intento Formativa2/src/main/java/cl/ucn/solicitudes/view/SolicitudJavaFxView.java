package cl.ucn.solicitudes.view;

import cl.ucn.solicitudes.controller.SolicitudController;
import cl.ucn.solicitudes.domain.model.EstadoSolicitud;
import cl.ucn.solicitudes.domain.model.Estudiante;
import cl.ucn.solicitudes.domain.model.Solicitud;
import cl.ucn.solicitudes.domain.service.NotificadorExterno;
import cl.ucn.solicitudes.domain.service.PublicadorEventosSolicitud;
import cl.ucn.solicitudes.infra.external.ServicioCorreoExterno;
import cl.ucn.solicitudes.infra.jpa.EstudianteRepository;
import cl.ucn.solicitudes.infra.jpa.SolicitudRepository;
import cl.ucn.solicitudes.infra.messaging.VertxPublicadorEventosSolicitud;
import io.vertx.core.Vertx;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Vista JavaFX mínima.
 *
 * Esta clase representa la capa View del patrón MVC.
 *
 * Responsabilidad esperada:
 * - capturar datos desde la interfaz;
 * - mostrar resultados;
 * - delegar acciones en el controlador.
 *
 * No debería acceder a repositorios ni a servicios externos.
 */
public class SolicitudJavaFxView {

    private final SolicitudController controller;

    public SolicitudJavaFxView(SolicitudController sc) {
        this.controller = sc;
        // Se invierte la dependencia
    }

    public void mostrar(Stage stage) {
        Label titulo = new Label("Sistema de solicitudes académicas");

        TextField nombreField = new TextField();
        nombreField.setPromptText("Nombre del estudiante");

        TextField correoField = new TextField();
        correoField.setPromptText("Correo institucional");

        TextField tipoField = new TextField();
        tipoField.setPromptText("Tipo de solicitud");

        TextArea descripcionArea = new TextArea();
        descripcionArea.setPromptText("Descripción de la solicitud");
        descripcionArea.setPrefRowCount(4);

        ComboBox<EstadoSolicitud> estadoComboBox = new ComboBox<>();
        estadoComboBox.getItems().addAll(
                EstadoSolicitud.EN_REVISION,
                EstadoSolicitud.APROBADA,
                EstadoSolicitud.RECHAZADA
        );
        estadoComboBox.setValue(EstadoSolicitud.EN_REVISION);

        Label resultadoLabel = new Label("Ingrese los datos y presione Registrar solicitud.");

        Button registrarButton = new Button("Registrar solicitud");
        registrarButton.setOnAction(event -> {
            try {
                Estudiante estudiante = controller.registrarEstudiante(
                        nombreField.getText(),
                        correoField.getText()
                );

                Solicitud solicitud = controller.crearSolicitud(
                        estudiante.getId(),
                        tipoField.getText(),
                        descripcionArea.getText()
                );

                Solicitud actualizada = controller.cambiarEstado(
                        solicitud.getId(),
                        estadoComboBox.getValue()
                );

                resultadoLabel.setText(
                        "Solicitud ID " + actualizada.getId()
                                + " creada para " + estudiante.getNombre()
                                + " con estado " + actualizada.getEstado()
                );
            } catch (Exception ex) {
                resultadoLabel.setText("Error: " + ex.getMessage());
            }
        });

        GridPane formulario = new GridPane();
        formulario.setHgap(10);
        formulario.setVgap(10);

        formulario.add(new Label("Nombre:"), 0, 0);
        formulario.add(nombreField, 1, 0);

        formulario.add(new Label("Correo:"), 0, 1);
        formulario.add(correoField, 1, 1);

        formulario.add(new Label("Tipo:"), 0, 2);
        formulario.add(tipoField, 1, 2);

        formulario.add(new Label("Descripción:"), 0, 3);
        formulario.add(descripcionArea, 1, 3);

        formulario.add(new Label("Nuevo estado:"), 0, 4);
        formulario.add(estadoComboBox, 1, 4);

        VBox root = new VBox(12, titulo, formulario, registrarButton, resultadoLabel);
        root.setPadding(new Insets(16));

        Scene scene = new Scene(root, 620, 420);
        stage.setTitle("Solicitudes académicas - MVC degradado");
        stage.setScene(scene);
        stage.show();
    }
}
