package progettoelle.registrazionevoti.repositories.hibernate;

import java.util.List;
import javax.persistence.PersistenceException;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Enrollment;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.EnrollmentRepository;

public class EnrollmentRepositoryHibernate extends HibernateRepository implements EnrollmentRepository {

    @Override
    public void createEnrollment(Enrollment enrollment) throws DataLayerException {
        initializeOperation();
        
        try {
            transaction.begin();
            entityManager.persist(enrollment);
            transaction.commit();
        } catch(PersistenceException ex) {
            handleOperationException(ex);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Student> findStudentsEnrolledOnCourse(Course course) throws DataLayerException {
        initializeOperation();
        List<Student> results = null;
        
        try {
            transaction.begin();
            String hql = "SELECT e.student FROM Enrollment e WHERE e.course=:course";
            results = entityManager.createQuery(hql).setParameter("course", course).getResultList();
            transaction.commit();
        } catch(PersistenceException ex) {
            handleOperationException(ex);
        } finally {
            entityManager.close();
        }
        
        return results;
    }

    @Override
    public List<Enrollment> findEnrollmentByStudent(Student student) throws DataLayerException {
        initializeOperation();
        List<Enrollment> results = null;
        
        try {
            transaction.begin();
            String hql = "SELECT e FROM Enrollment e WHERE e.student=:student";
            results = entityManager.createQuery(hql).setParameter("student", student).getResultList();
            transaction.commit();
        } catch(PersistenceException ex) {
            handleOperationException(ex);
        } finally {
            entityManager.close();
        }
        
        return results;
    }

    @Override
    public Enrollment findEnrollmentByStudentAndCourse(Student student, Course course) throws DataLayerException {
        initializeOperation();
        Enrollment result = null;
        
        try {
            transaction.begin();
            String hql = "SELECT e FROM Enrollment e WHERE  e.student=:student AND e.course=:course";
            result = (Enrollment)entityManager.createQuery(hql)
                    .setParameter("student", student)
                    .setParameter("course", course)
                    .getSingleResult();
            transaction.commit();
        } catch(PersistenceException ex) {
            handleOperationException(ex);
        } finally {
            entityManager.close();
        }
        
        return result;
    }

    @Override
    public void updateEnrollment(Enrollment enrollment) throws DataLayerException {
        initializeOperation();
        
        try {
            transaction.begin();
            entityManager.merge(enrollment);
            transaction.commit();            
        } catch(PersistenceException ex) {
            handleOperationException(ex);
        } finally {
            entityManager.close();
        }
    }

}
