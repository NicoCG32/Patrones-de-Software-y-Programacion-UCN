package cl.ucn.solicitudes.domain.service;

public interface NotificadorExterno {

    void enviarCorreo(String destinatario, String asunto, String cuerpo);
}
