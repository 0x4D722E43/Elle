package progettoelle.registrazionevoti.repositories;

import java.util.List;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.domain.Student;

public interface ExamResultRepository {
    
    void createExamResult(ExamResult examResult) throws DataLayerException;
    
    List<ExamResult> findExamResultByExam(Exam exam) throws DataLayerException;
    
    List<ExamResult> findStudentBookings(Student student) throws DataLayerException;

    List<ExamResult> findStudentResults(Student student) throws DataLayerException;
    
    List<ExamResult> findStudentResultsHistory(Student student) throws DataLayerException;

    void updateExamResult(ExamResult examResult) throws DataLayerException;
    
    void deleteExamResult(ExamResult examResult) throws DataLayerException;
    
    void deleteAllBookingsForCourse(Student student, Course course) throws DataLayerException;

}
