package progettoelle.registrazionevoti.services.manageexam;

import java.util.List;
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.ExamResultRepository;
import progettoelle.registrazionevoti.services.BaseService;

public final class ManageExamBookingsService extends BaseService {
    
    private final ExamResultRepository examResultRepository;

    public ManageExamBookingsService(ExamResultRepository examResultRepository) {
        this.examResultRepository = examResultRepository;
    }
    
    public List<ExamResult> getExamBookings(Student student) throws DataLayerException {
        return examResultRepository.findStudentBookings(student);
    }
    
    public void cancelExamBooking(ExamResult examResult) throws DataLayerException {
        examResultRepository.deleteExamResult(examResult);
    }
    
}
