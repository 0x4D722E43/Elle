package progettoelle.registrazionevoti.services;

import java.util.List;
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.ExamResultRepository;

public final class ManageExamResultsHistory {
    
    private final ExamResultRepository examResultRepository;

    public ManageExamResultsHistory(ExamResultRepository examResultRepository) {
        this.examResultRepository = examResultRepository;
    }
    
    public List<ExamResult> getExamResultHistory(Student student) throws DataLayerException {
        return examResultRepository.findStudentResultsHistory(student);
    }
    
}
