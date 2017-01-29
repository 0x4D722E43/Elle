package progettoelle.registrazionevoti.services;

import java.util.List;
import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.domain.ExamResultStatus;
import progettoelle.registrazionevoti.mail.MailService;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.ExamResultRepository;

public final class GradeExamService {

    private static final String ALREADY_GRADED_EXAM = "E' già stato assegnato un voto a questo esame";
    
    private final ExamResultRepository examResultRepository;
    private final MailService mailService;

    public GradeExamService(ExamResultRepository examResultRepository, MailService mailService) {
        this.examResultRepository = examResultRepository;
        this.mailService = mailService;
    }

    public List<ExamResult> getExamResults(Exam exam) throws DataLayerException {
        return examResultRepository.findExamResultByExam(exam);
    }

    public void gradeExam(int mark, ExamResult examResult) throws ValidationException, DataLayerException {
        if (examResult.getStatus() != ExamResultStatus.BOOKED) throw new ValidationException(ALREADY_GRADED_EXAM);
        examResult.setMark(mark);
        examResultRepository.updateExamResult(examResult);
    }
    
}
