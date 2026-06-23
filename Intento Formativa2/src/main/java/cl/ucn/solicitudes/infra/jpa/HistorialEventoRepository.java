package cl.ucn.solicitudes.infra.jpa;

import cl.ucn.solicitudes.domain.model.HistorialEvento;
import jakarta.persistence.EntityManager;

import java.util.List;

public class HistorialEventoRepository {

    public HistorialEvento guardar(HistorialEvento evento) {
        EntityManager em = JpaUtil.entityManager();
        try {
            em.getTransaction().begin();
            em.persist(evento);
            em.flush();
            em.getTransaction().commit();
            return evento;
        } finally {
            em.close();
        }
    }

    public List<HistorialEvento> buscarTodos() {
        EntityManager em = JpaUtil.entityManager();
        try {
            return em.createQuery("select h from HistorialEvento h", HistorialEvento.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }
}
