package progettoelle.registrazionevoti.services;

import java.util.List;
import progettoelle.registrazionevoti.domain.Enrollment;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.EnrollmentRepository;

public final class ManageEnrollmentsService {
    
    private final EnrollmentRepository enrollmentRepository;

    public ManageEnrollmentsService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }
    
    public List<Enrollment> getEnrollments(Student student) throws DataLayerException {
        return enrollmentRepository.findEnrollmentByStudent(student);
    }

}
