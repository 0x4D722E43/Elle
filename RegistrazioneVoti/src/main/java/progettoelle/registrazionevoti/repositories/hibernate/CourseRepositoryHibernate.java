package progettoelle.registrazionevoti.repositories.hibernate;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.CourseRepository;
import progettoelle.registrazionevoti.repositories.DataLayerException;

public class CourseRepositoryHibernate extends HibernateRepository implements CourseRepository {
    
    @Override
    public void createCourse(Course course) throws DataLayerException {
        initializeOperation();
        
        try {
            transaction.begin();
            entityManager.persist(course);
            transaction.commit();
        } catch(PersistenceException ex) {
            handleOperationException(ex);
        } finally {
            entityManager.close();
        }
    }
    
    @Override
    public Course findCourseByName(String name) throws DataLayerException {
        initializeOperation();
        Course result = null;
        
        try {
            transaction.begin();
            String hql = "SELECT c FROM Course c WHERE c.name =:name";
            result = (Course)entityManager.createQuery(hql).setParameter("name", name).getSingleResult();
            transaction.commit();
        } catch(NoResultException ignored) {
        } catch(PersistenceException ex) {
            handleOperationException(ex);
        } finally {
            entityManager.close();
        }
        
        return result;
    }

    @Override
    public List<Course> findCourseByProfessor(Professor professor) throws DataLayerException {
        initializeOperation();
        List<Course> results = null;
        
        try {
            transaction.begin();
            String hql = "SELECT c FROM Course c WHERE c.professor =:professor";
            results = entityManager.createQuery(hql).setParameter("professor", professor).getResultList();
            transaction.commit();
        } catch(PersistenceException ex) {
            handleOperationException(ex);
        } finally {
            entityManager.close();
        }
        
        return results;
    }

    @Override
    public List<Course> findAvailableCoursesForStudent(Student student) throws DataLayerException {
        initializeOperation();
        List<Course> results = null;
        
        try {
            transaction.begin();
            String hql = "SELECT c FROM Course c WHERE c.degreeCourse = :degreeCourse AND c NOT IN " +
                "(SELECT e.course FROM Enrollment e WHERE e.student =:student)";
            results = entityManager.createQuery(hql)
                    .setParameter("degreeCourse", student.getDegreeCourse())
                    .setParameter("student", student)
                    .getResultList();
            transaction.commit();
        } catch(PersistenceException ex) {
            handleOperationException(ex);
        } finally {
            entityManager.close();
        }
        
        return results;
    }
    
}
