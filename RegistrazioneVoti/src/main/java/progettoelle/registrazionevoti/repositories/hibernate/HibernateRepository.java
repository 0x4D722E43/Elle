package progettoelle.registrazionevoti.repositories.hibernate;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import progettoelle.registrazionevoti.repositories.DataLayerException;

public abstract class HibernateRepository {

    private static final Logger LOG = Logger.getLogger(HibernateRepository.class.getName());
    
    protected EntityManager entityManager;
    protected EntityTransaction transaction;
        
    protected void initializeOperation() {
        entityManager = PersistenceManager.getInstance().getEntityManager();
        transaction = entityManager.getTransaction();
    }
    
    protected void handleOperationException(PersistenceException ex) throws DataLayerException {
        if (transaction != null && transaction.isActive()) transaction.rollback();
        LOG.log(Level.SEVERE, null, ex);
        throw new DataLayerException(); 
    }
    
}
