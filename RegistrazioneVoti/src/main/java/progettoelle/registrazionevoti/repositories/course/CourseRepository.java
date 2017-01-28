package progettoelle.registrazionevoti.repositories.course;

import java.util.List;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;

public interface CourseRepository {
    
    void createCourse(Course course) throws DataLayerException;
    
    Course findCourseByName(String name) throws DataLayerException;
    
    List<Course> findCourseByProfessor(Professor professor) throws DataLayerException;

    List<Course> findAvailableCoursesForStudent(Student student) throws DataLayerException;

}
