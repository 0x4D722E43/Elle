package progettoelle.registrazionevoti.repositories.hibernate;

import java.util.List;
import javax.persistence.PersistenceException;
import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.ExamResultRepository;

public class ExamResultRepositoryHibernate extends HibernateRepository implements ExamResultRepository {

    @Override
    public void createExamResult(ExamResult examResult) throws DataLayerException {
        initializeOperation();
        
        try {
            transaction.begin();
            entityManager.persist(examResult);
            transaction.commit();
        } catch(PersistenceException ex) {
            handleOperationException(ex);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<ExamResult> findExamResultByExam(Exam exam) throws DataLayerException {
        initializeOperation();
        List<ExamResult> results = null;
        
        try {
            transaction.begin();
            String hql = "SELECT e FROM ExamResult e WHERE e.exam=:exam AND (e.status='BOOKED' OR e.status='PASSED_PENDING' OR e.status='FAILED_PENDING')";
            results = entityManager.createQuery(hql).setParameter("exam", exam).getResultList();
            transaction.commit();
        } catch(PersistenceException ex) {
            handleOperationException(ex);
        } finally {
            entityManager.close();
        }
        
        return results;
    }

    @Override
    public List<ExamResult> findStudentBookings(Student student) throws DataLayerException {
        initializeOperation();
        List<ExamResult> results = null;
        
        try {
            transaction.begin();
            String hql = "SELECT e FROM ExamResult e WHERE e.student=:student AND e.status='BOOKED'";
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
    public List<ExamResult> findStudentResults(Student student) throws DataLayerException {
        initializeOperation();
        List<ExamResult> results = null;
        
        try {
            transaction.begin();
            String hql = "SELECT e FROM ExamResult e WHERE e.student=:student AND (e.status='PASSED_PENDING' OR e.status='FAILED_PENDING')";
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
    public List<ExamResult> findStudentResultsHistory(Student student) throws DataLayerException {
        initializeOperation();
        List<ExamResult> results = null;
        
        try {
            transaction.begin();
            String hql = "SELECT e FROM ExamResult e WHERE e.student=:student AND (e.status='ACCEPTED' OR e.status='REJECTED' OR e.status='FAILED')";
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
    public void updateExamResult(ExamResult examResult) throws DataLayerException {
        initializeOperation();
        
        try {
            transaction.begin();
            entityManager.merge(examResult);
            transaction.commit();            
        } catch(PersistenceException ex) {
            handleOperationException(ex);
        } finally {
            entityManager.close();
        }
    }
    
    @Override
    public void deleteExamResult(ExamResult examResult) throws DataLayerException {
        initializeOperation();
        
        try {
            transaction.begin();
            entityManager.remove(entityManager.merge(examResult));
            transaction.commit();            
        } catch(PersistenceException ex) {
            handleOperationException(ex);
        } finally {
            entityManager.close();
        }
    }

}
