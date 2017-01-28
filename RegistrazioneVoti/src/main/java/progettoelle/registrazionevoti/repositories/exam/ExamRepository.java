package progettoelle.registrazionevoti.repositories.exam;

import java.util.List;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;

public interface ExamRepository {
    
    void createExam(Exam exam) throws DataLayerException;
    
    List<Exam> findExamByCourse(Course course) throws DataLayerException;
    
    List<Exam> findAvailableExamsForStudent(Student student) throws DataLayerException;

    void updateExam(Exam exam) throws DataLayerException;

}
