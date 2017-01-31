package progettoelle.registrazionevoti.services.managecourse;

import java.util.List;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.EnrollmentRepository;

public final class LoadEnrolledStudentsService {
    
    private final EnrollmentRepository enrollmentRepository;

    public LoadEnrolledStudentsService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public List<Student> getEnrolledStudents(Course course) throws DataLayerException {
        return enrollmentRepository.findStudentsEnrolledOnCourse(course);
    }
    
}
