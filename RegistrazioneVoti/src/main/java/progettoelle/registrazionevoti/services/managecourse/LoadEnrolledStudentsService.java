package progettoelle.registrazionevoti.services.managecourse;

import java.util.List;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Enrollment;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.EnrollmentRepository;
import progettoelle.registrazionevoti.services.BaseService;

public final class LoadEnrolledStudentsService extends BaseService {
    
    private final EnrollmentRepository enrollmentRepository;

    public LoadEnrolledStudentsService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public List<Enrollment> getEnrolledStudents(Course course) throws DataLayerException {
        return enrollmentRepository.findStudentsEnrolledOnCourse(course);
    }
    
}
