package progettoelle.registrazionevoti.services.manageexam;

import java.util.List;
import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.ExamResultRepository;
import progettoelle.registrazionevoti.services.ValidationException;

public final class GradeExamService {

    private final ExamResultRepository examResultRepository;

    public GradeExamService(ExamResultRepository examResultRepository) {
        this.examResultRepository = examResultRepository;
    }

    public List<ExamResult> getExamResults(Exam exam) throws DataLayerException {
        return examResultRepository.findExamResultByExam(exam);
    }

    public void gradeExam(int mark, ExamResult examResult) throws ValidationException, DataLayerException {
        examResult.grade(mark);
        examResultRepository.updateExamResult(examResult);
    }
    
}
