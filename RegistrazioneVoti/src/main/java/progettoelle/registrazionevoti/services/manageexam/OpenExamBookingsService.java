package progettoelle.registrazionevoti.services.manageexam;

import java.util.List;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.ExamRepository;
import progettoelle.registrazionevoti.services.BaseService;

public final class OpenExamBookingsService extends BaseService {

    private final ExamRepository examRepository;

    public OpenExamBookingsService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }
    
    public List<Exam> getExams(Course course) throws DataLayerException {
        return examRepository.findExamByCourse(course);
    }

    public void openExamBookings(Exam exam) throws DataLayerException {
        exam.openBookings();
        examRepository.updateExam(exam);
    }

    public void closeExamBookings(Exam exam) throws DataLayerException {
        exam.closeBookings();
        examRepository.updateExam(exam);
    }
    
}
