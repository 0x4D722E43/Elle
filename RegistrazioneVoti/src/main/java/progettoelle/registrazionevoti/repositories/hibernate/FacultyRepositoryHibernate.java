package progettoelle.registrazionevoti.repositories.hibernate;

import java.util.List;
import javax.persistence.PersistenceException;
import progettoelle.registrazionevoti.domain.Faculty;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.FacultyRepository;

public class FacultyRepositoryHibernate extends HibernateRepository implements FacultyRepository {
    
    public void createFaculty(Faculty faculty) throws DataLayerException {
        initializeOperation();
        
        try {
            transaction.begin();
            entityManager.persist(faculty);
            transaction.commit();
        } catch(PersistenceException ex) {
            handleOperationException(ex);
        } finally {
            entityManager.close();
        }
    }
    
    @Override 
    public List<Faculty> findAllFaculties() throws DataLayerException {
        initializeOperation();
        List<Faculty> results = null;
        
        try {
            transaction.begin();
            String hql = "SELECT f FROM Faculty f";
            results = entityManager.createQuery(hql).getResultList();     
            transaction.commit();
        } catch(PersistenceException ex) {
            handleOperationException(ex);
        } finally {
            entityManager.close();
        }
        
        return results;
    }

}
