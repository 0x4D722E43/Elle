package progettoelle.registrazionevoti.services.manageexam;

import java.util.Calendar;
import java.util.List;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.repositories.CourseRepository;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.ExamRepository;
import progettoelle.registrazionevoti.services.BaseService;

public final class CreateExamService extends BaseService {

    private final CourseRepository courseRepository;
    private final ExamRepository examRepository;

    public CreateExamService(CourseRepository courseRepository, ExamRepository examRepository) {
        this.courseRepository = courseRepository;
        this.examRepository = examRepository;
    }
    
    public List<Course> getPossibleCourses(Professor professor) throws DataLayerException {
        return courseRepository.findCourseByProfessor(professor); 
    }

    public void createExam(Course course, Calendar date, String room, String description) throws DataLayerException {
        Exam exam = new Exam(course, date, room, description);
        examRepository.createExam(exam);
    }
    
}
