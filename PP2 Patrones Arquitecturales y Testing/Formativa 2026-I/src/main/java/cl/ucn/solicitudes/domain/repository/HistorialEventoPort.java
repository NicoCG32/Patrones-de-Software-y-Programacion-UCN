package cl.ucn.solicitudes.domain.repository;

import cl.ucn.solicitudes.domain.model.HistorialEvento;

public interface HistorialEventoPort {

    HistorialEvento guardar(HistorialEvento evento);
}
