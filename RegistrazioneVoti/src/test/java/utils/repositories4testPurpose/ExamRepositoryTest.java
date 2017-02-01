package utils.repositories4testPurpose;

import java.util.List;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.ExamRepository;

public class ExamRepositoryTest implements ExamRepository{
    private TestDataBase db;

    public ExamRepositoryTest(TestDataBase db) {
        this.db = db;
    }
    
    @Override
    public void createExam(Exam exam) throws DataLayerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Exam> findExamByCourse(Course course) throws DataLayerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Exam> findAvailableExamsForStudent(Student student) throws DataLayerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateExam(Exam exam) throws DataLayerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
