package cl.ucn.solicitudes.infra.jpa;

import cl.ucn.solicitudes.domain.model.Estudiante;
import cl.ucn.solicitudes.domain.repository.EstudiantePort;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class EstudianteRepository implements EstudiantePort {

    public Estudiante guardar(Estudiante estudiante) {
        EntityManager em = JpaUtil.entityManager();
        try {
            em.getTransaction().begin();
            if (estudiante.getId() == null) {
                em.persist(estudiante);
            } else {
                estudiante = em.merge(estudiante);
            }
            em.flush();
            em.getTransaction().commit();
            return estudiante;
        } finally {
            em.close();
        }
    }

    public Optional<Estudiante> buscarPorId(Long id) {
        EntityManager em = JpaUtil.entityManager();
        try {
            return Optional.ofNullable(em.find(Estudiante.class, id));
        } finally {
            em.close();
        }
    }

    public List<Estudiante> buscarTodos() {
        EntityManager em = JpaUtil.entityManager();
        try {
            return em.createQuery("select e from Estudiante e", Estudiante.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }
}
