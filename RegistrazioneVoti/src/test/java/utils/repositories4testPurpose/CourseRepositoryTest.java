package utils.repositories4testPurpose;

import java.util.List;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.CourseRepository;
import progettoelle.registrazionevoti.repositories.DataLayerException;

public class CourseRepositoryTest implements CourseRepository{

    @Override
    public void createCourse(Course course) throws DataLayerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Course findCourseByName(String name) throws DataLayerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Course> findCourseByProfessor(Professor professor) throws DataLayerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Course> findAvailableCoursesForStudent(Student student) throws DataLayerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
