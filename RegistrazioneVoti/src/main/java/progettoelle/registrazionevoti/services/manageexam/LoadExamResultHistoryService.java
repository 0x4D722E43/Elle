package progettoelle.registrazionevoti.services.manageexam;

import java.util.List;
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.ExamResultRepository;
import progettoelle.registrazionevoti.services.BaseService;

public final class LoadExamResultHistoryService extends BaseService {
    
    private final ExamResultRepository examResultRepository;

    public LoadExamResultHistoryService(ExamResultRepository examResultRepository) {
        this.examResultRepository = examResultRepository;
    }
    
    public List<ExamResult> getExamResultHistory(Student student) throws DataLayerException {
        return examResultRepository.findStudentResultsHistory(student);
    }
    
}
