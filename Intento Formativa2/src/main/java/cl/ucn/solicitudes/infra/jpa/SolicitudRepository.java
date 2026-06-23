package cl.ucn.solicitudes.infra.jpa;

import cl.ucn.solicitudes.domain.model.EstadoSolicitud;
import cl.ucn.solicitudes.domain.model.Solicitud;
import cl.ucn.solicitudes.domain.repository.SolicitudPort;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class SolicitudRepository implements SolicitudPort {

    public Solicitud guardar(Solicitud solicitud) {
        EntityManager em = JpaUtil.entityManager();
        try {
            em.getTransaction().begin();
            if (solicitud.getId() == null) {
                em.persist(solicitud);
            } else {
                solicitud = em.merge(solicitud);
            }
            em.flush();
            em.getTransaction().commit();
            return solicitud;
        } finally {
            em.close();
        }
    }

    public Optional<Solicitud> buscarPorId(Long id) {
        EntityManager em = JpaUtil.entityManager();
        try {
            return Optional.ofNullable(em.find(Solicitud.class, id));
        } finally {
            em.close();
        }
    }

    public List<Solicitud> buscarPorEstado(EstadoSolicitud estado) {
        EntityManager em = JpaUtil.entityManager();
        try {
            return em.createQuery(
                    "select s from Solicitud s where s.estado = :estado",
                    Solicitud.class
            ).setParameter("estado", estado).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Solicitud> buscarTodas() {
        EntityManager em = JpaUtil.entityManager();
        try {
            return em.createQuery("select s from Solicitud s", Solicitud.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }
}
