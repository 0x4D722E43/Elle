package progettoelle.registrazionevoti.services.managecourse;

import java.util.List;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.DegreeCourse;
import progettoelle.registrazionevoti.domain.Enrollment;
import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.repositories.CourseRepository;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.DegreeCourseRepository;
import progettoelle.registrazionevoti.repositories.EnrollmentRepository;
import progettoelle.registrazionevoti.services.BaseService;
import progettoelle.registrazionevoti.services.ValidationException;

public final class ConcreteCoursesService extends BaseService implements CoursesService,LoadEnrolledStudentsService {
    
    private static final String ALREADY_EXISTENT_COURSE = "Esiste già un corso con questo nome";
    
    private final DegreeCourseRepository degreeCourseRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;

    public ConcreteCoursesService(DegreeCourseRepository degreeCourseRepository, CourseRepository courseRepository,EnrollmentRepository enrollmentRepository) {
        this.degreeCourseRepository = degreeCourseRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }
    
    @Override
    public List<DegreeCourse> getPossibleDegreeCourses() throws DataLayerException {
        return degreeCourseRepository.findAllDegreeCourses();
    }

    /**
     * Permette la creazione di un esame,
     * rilascia una ValidationException 
     * se esiste già un corso con lo stesso nome
     * @param name
     * @param credits
     * @param professor
     * @param degreeCourse
     * @throws ValidationException
     * @throws DataLayerException
     */
    @Override
    public void createCourse(String name, int credits, Professor professor, DegreeCourse degreeCourse) throws ValidationException, DataLayerException {
        if (courseRepository.findCourseByName(name) != null) throw new ValidationException(ALREADY_EXISTENT_COURSE);
        
        Course course = new Course(name, credits, professor, degreeCourse);
        courseRepository.createCourse(course);
    }

    @Override
    public List<Enrollment> getEnrolledStudents(Course course) throws DataLayerException {
        return enrollmentRepository.findStudentsEnrolledOnCourse(course);
    }

    @Override
    public List<Course> getCourses(Professor professor) throws DataLayerException {
        return courseRepository.findCourseByProfessor(professor);
    }

}
