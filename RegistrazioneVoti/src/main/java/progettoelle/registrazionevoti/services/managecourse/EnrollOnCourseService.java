package progettoelle.registrazionevoti.services.managecourse;

import java.util.List;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Enrollment;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.CourseRepository;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.EnrollmentRepository;

public final class EnrollOnCourseService {
    
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;

    public EnrollOnCourseService(CourseRepository courseRepository, EnrollmentRepository enrollmentRepository) {
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }
    
    public List<Course> getCoursesOnWhichStudentCanEnroll(Student student) throws DataLayerException {
        return courseRepository.findAvailableCoursesForStudent(student);
    }

    public void enrollOnCourse(Student student, Course course) throws DataLayerException {
        Enrollment enrollment = new Enrollment(student, course);
        enrollmentRepository.createEnrollment(enrollment);
    }

}
