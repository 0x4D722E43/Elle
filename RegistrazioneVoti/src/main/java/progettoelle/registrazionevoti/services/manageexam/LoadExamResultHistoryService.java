package progettoelle.registrazionevoti.services.manageexam;

import java.util.List;
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.ExamResultRepository;

public final class LoadExamResultHistoryService {
    
    private final ExamResultRepository examResultRepository;

    public LoadExamResultHistoryService(ExamResultRepository examResultRepository) {
        this.examResultRepository = examResultRepository;
    }
    
    public List<ExamResult> getExamResultHistory(Student student) throws DataLayerException {
        return examResultRepository.findStudentResultsHistory(student);
    }
    
}
