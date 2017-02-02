package progettoelle.registrazionevoti.repositories.hibernate;

import java.util.List;
import javax.persistence.PersistenceException;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.ExamRepository;

public class ExamRepositoryHibernate extends HibernateRepository implements ExamRepository {

    @Override
    public void createExam(Exam exam) throws DataLayerException {
        initializeOperation();
        
        try {
            transaction.begin();
            entityManager.persist(exam);
            transaction.commit();
        } catch(PersistenceException ex) {
            handleOperationException(ex);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Exam> findExamByCourse(Course course) throws DataLayerException {
        initializeOperation();
        List<Exam> results = null;
        
        try {
            transaction.begin();
            String hql = "SELECT e FROM Exam e WHERE e.course=:course";
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
    public List<Exam> findAvailableExamsForStudent(Student student) throws DataLayerException {
        initializeOperation();
        List<Exam> results = null;
        
        try {
            transaction.begin();
            String hql = "SELECT e FROM Exam e WHERE e.bookingOpen is true AND " +
                "e.course NOT IN (SELECT er.exam.course FROM ExamResult er WHERE er.student=:student AND (er.status='PASSED_PENDING' OR er.status='BOOKED')) AND " +
                "e.course IN (SELECT enr.course FROM Enrollment enr WHERE enr.student=:student AND enr.completed is false) AND " +
                "e NOT IN (SELECT ex.exam FROM ExamResult ex WHERE ex.student=:student)";
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
    public void updateExam(Exam exam) throws DataLayerException {
        initializeOperation();
        
        try {
            transaction.begin();
            entityManager.merge(exam);
            transaction.commit();            
        } catch(PersistenceException ex) {
            handleOperationException(ex);
        } finally {
            entityManager.close();
        }
    }
    
}
