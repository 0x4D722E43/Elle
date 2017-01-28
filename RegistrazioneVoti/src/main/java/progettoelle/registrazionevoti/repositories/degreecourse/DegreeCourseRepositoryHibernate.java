package progettoelle.registrazionevoti.repositories.degreecourse;

import java.util.List;
import javax.persistence.PersistenceException;
import progettoelle.registrazionevoti.domain.DegreeCourse;
import progettoelle.registrazionevoti.domain.Faculty;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.HibernateRepository;

public class DegreeCourseRepositoryHibernate extends HibernateRepository implements DegreeCourseRepository {

    @Override
    public List<DegreeCourse> findDegreeCourseByFaculty(Faculty faculty) throws DataLayerException {
        initializeOperation();
        List<DegreeCourse> results = null;
        
        try {
            transaction.begin();
            String hql = "SELECT d FROM DegreeCourse d WHERE d.faculty.id =:faculty";
            results = entityManager.createQuery(hql).setParameter("faculty", faculty).getResultList();
            transaction.commit();
        } catch(PersistenceException ex) {
            handleOperationException(ex);
        } finally {
            entityManager.close();
        }
        
        return results;
    }
    
}
