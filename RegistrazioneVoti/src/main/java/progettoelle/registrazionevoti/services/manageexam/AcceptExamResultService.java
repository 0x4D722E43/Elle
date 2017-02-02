package progettoelle.registrazionevoti.services.manageexam;

import java.util.List;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Enrollment;
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.domain.ExamResultStatus;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.EnrollmentRepository;
import progettoelle.registrazionevoti.repositories.ExamResultRepository;
import progettoelle.registrazionevoti.services.BaseService;

public final class AcceptExamResultService extends BaseService {
    
    private final ExamResultRepository examResultRepository;
    private final EnrollmentRepository enrollmentRepository;

    public AcceptExamResultService(ExamResultRepository examResultRepository, EnrollmentRepository enrollmentRepository) {
        this.examResultRepository = examResultRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    public List<ExamResult> getExamsResults(Student student) throws DataLayerException {
        return examResultRepository.findStudentResults(student);
    }

    public void acceptExamResult(Student student, ExamResult examResult) throws DataLayerException {
        examResult.setStatus(ExamResultStatus.ACCEPTED);
        examResultRepository.updateExamResult(examResult);
        
        Course course = examResult.getCourse();
        examResultRepository.deleteAllBookingsForCourse(student, course);
        
        Enrollment enrollment = enrollmentRepository.findEnrollmentByStudentAndCourse(student, course);
        enrollment.complete(examResult.getGrade());
        enrollmentRepository.updateEnrollment(enrollment);
    }

    public void rejectExamResult(Student student, ExamResult examResult) throws DataLayerException {
        examResult.setStatus(ExamResultStatus.REJECTED);
        examResultRepository.updateExamResult(examResult);
    }
    
    public void acknowledgeFailedExam(Student student, ExamResult examResult) throws DataLayerException {
        examResult.setStatus(ExamResultStatus.FAILED);
        examResultRepository.updateExamResult(examResult);
    }
    
}
