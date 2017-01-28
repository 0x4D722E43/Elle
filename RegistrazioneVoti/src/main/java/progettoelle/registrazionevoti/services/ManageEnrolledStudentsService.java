package progettoelle.registrazionevoti.services;

import java.util.List;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.enrollment.EnrollmentRepository;

public final class ManageEnrolledStudentsService {
    
    private final EnrollmentRepository enrollmentRepository;

    public ManageEnrolledStudentsService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public List<Student> getEnrolledStudents(Course course) throws DataLayerException {
        return enrollmentRepository.findStudentsEnrolledOnCourse(course);
    }
    
}
