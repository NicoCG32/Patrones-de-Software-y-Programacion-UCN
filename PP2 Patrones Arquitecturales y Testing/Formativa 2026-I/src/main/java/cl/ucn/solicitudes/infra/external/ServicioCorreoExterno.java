package cl.ucn.solicitudes.infra.external;

import cl.ucn.solicitudes.domain.service.NotificadorExterno;

/**
 * Simula un servicio externo.
 *
 * En pruebas unitarias debe reemplazarse por un mock.
 */
public class ServicioCorreoExterno implements NotificadorExterno {

    @Override
    public void enviarCorreo(String destinatario, String asunto, String cuerpo) {
        System.out.println("[SERVICIO EXTERNO] Enviando correo a " + destinatario);
        System.out.println(asunto);
        System.out.println(cuerpo);
    }
}
