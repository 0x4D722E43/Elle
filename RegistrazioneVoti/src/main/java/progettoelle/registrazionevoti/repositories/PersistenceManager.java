package progettoelle.registrazionevoti.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
    
    private static PersistenceManager INSTANCE;
    private EntityManagerFactory entityManagerFactory;
    
    private PersistenceManager() {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_progetto");
    }
    
    public static PersistenceManager getInstance() {
        if (INSTANCE == null) INSTANCE = new PersistenceManager();
        return INSTANCE;
    }
    
    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
    
    public void close() {
        entityManagerFactory.close();
    }
    
}
