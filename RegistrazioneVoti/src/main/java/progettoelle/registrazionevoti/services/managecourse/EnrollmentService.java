package progettoelle.registrazionevoti.services.managecourse;

import java.util.List;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Enrollment;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.CourseRepository;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.EnrollmentRepository;
import progettoelle.registrazionevoti.services.BaseService;

public final class EnrollmentService extends BaseService implements EnrollmentManager,LoadStudentEnrollments {
    
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(CourseRepository courseRepository, EnrollmentRepository enrollmentRepository) {
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }
    
    /**
     *
     * @param student
     * @return corsi ai quali lo studente può iscriversi
     * @throws DataLayerException
     */
    @Override
    public List<Course> getCoursesOnWhichStudentCanEnroll(Student student) throws DataLayerException {
        return courseRepository.findAvailableCoursesForStudent(student);
    }

    /**
     * Permette di iscrivere uno studente a un corso
     * @param student
     * @param course
     * @throws DataLayerException
     */
    @Override
    public void enrollOnCourse(Student student, Course course) throws DataLayerException {
        Enrollment enrollment = new Enrollment(student, course);
        enrollmentRepository.createEnrollment(enrollment);
    }

    @Override
    public List<Enrollment> getEnrollments(Student student) throws DataLayerException {
        return enrollmentRepository.findEnrollmentByStudent(student);
    }

}
