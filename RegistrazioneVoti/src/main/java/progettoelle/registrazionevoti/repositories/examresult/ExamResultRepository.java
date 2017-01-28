package progettoelle.registrazionevoti.repositories.examresult;

import java.util.List;
import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;

public interface ExamResultRepository {
    
    void createExamResult(ExamResult examResult) throws DataLayerException;
    
    List<ExamResult> findExamResultByExam(Exam exam) throws DataLayerException;
    
    List<ExamResult> findStudentBookings(Student student) throws DataLayerException;

    List<ExamResult> findStudentResults(Student student) throws DataLayerException;
    
    List<ExamResult> findStudentResultsHistory(Student student) throws DataLayerException;

    void updateExamResult(ExamResult examResult) throws DataLayerException;
    
    void deleteExamResult(ExamResult examResult) throws DataLayerException;
    
}
