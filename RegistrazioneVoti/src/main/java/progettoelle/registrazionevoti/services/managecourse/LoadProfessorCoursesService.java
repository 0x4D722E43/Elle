package progettoelle.registrazionevoti.services.managecourse;

import java.util.List;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.repositories.CourseRepository;
import progettoelle.registrazionevoti.repositories.DataLayerException;

public final class LoadProfessorCoursesService {
    
    private final CourseRepository courseRepository;

    public LoadProfessorCoursesService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    
    public List<Course> getCourses(Professor professor) throws DataLayerException {
        return courseRepository.findCourseByProfessor(professor);
    }

}