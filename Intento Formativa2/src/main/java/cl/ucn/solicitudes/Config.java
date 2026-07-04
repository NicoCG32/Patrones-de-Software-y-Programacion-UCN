package cl.ucn.solicitudes;

import cl.ucn.solicitudes.controller.SolicitudController;
import cl.ucn.solicitudes.domain.repository.SolicitudPort;
import cl.ucn.solicitudes.infra.external.ServicioCorreoExterno;
import cl.ucn.solicitudes.infra.jpa.EstudianteRepository;
import cl.ucn.solicitudes.infra.jpa.SolicitudRepository;
import cl.ucn.solicitudes.infra.messaging.VertxPublicadorEventosSolicitud;
import io.vertx.core.Vertx;

public class Config {

    public Config(){}
    public SolicitudController getController() {
        return new SolicitudController(
                new VertxPublicadorEventosSolicitud(Vertx.vertx()),
                new ServicioCorreoExterno(),
                new SolicitudRepository(),
                new EstudianteRepository()
        ); //, aquí cambiaría el servicio externo en caso de necesitarse
    }
}
