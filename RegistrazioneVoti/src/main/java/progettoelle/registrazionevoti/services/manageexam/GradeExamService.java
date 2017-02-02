package progettoelle.registrazionevoti.services.manageexam;

import java.util.List;
import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.ExamResultRepository;
import progettoelle.registrazionevoti.services.BaseService;

public final class GradeExamService extends BaseService {

    private final ExamResultRepository examResultRepository;

    public GradeExamService(ExamResultRepository examResultRepository) {
        this.examResultRepository = examResultRepository;
    }
    
    /**
     *
     * @param exam
     * @return I risultati(valutati o meno) del esame
     * @throws DataLayerException
     */
    public List<ExamResult> getExamResults(Exam exam) throws DataLayerException {
        return examResultRepository.findExamResultByExam(exam);
    }

    /**
     * Assegna una valutazione al risultato di un esame
     * 
     * @param mark
     * @param examResult
     * @throws DataLayerException
     */
    public void gradeExam(int mark, ExamResult examResult) throws DataLayerException {
        examResult.grade(mark);
        examResultRepository.updateExamResult(examResult);
    }
    
}
