package cl.ucn.solicitudes.infra.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Utilidad mínima para crear EntityManager.
 */
public final class JpaUtil {

    private static final EntityManagerFactory EMF =
            Persistence.createEntityManagerFactory("solicitudesPU");

    private JpaUtil() {
    }

    public static EntityManager entityManager() {
        return EMF.createEntityManager();
    }

    public static void cerrar() {
        EMF.close();
    }
}
