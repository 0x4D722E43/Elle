package utils.repositories4testPurpose;

import java.util.ArrayList;
import java.util.List;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Enrollment;
import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.CourseRepository;
import progettoelle.registrazionevoti.repositories.DataLayerException;

public class CourseRepositoryTest implements CourseRepository {

    private TestDataBase db;

    public CourseRepositoryTest(TestDataBase db) {
        this.db = db;
    }

    @Override
    public void createCourse(Course course) throws DataLayerException {
        List<Course> all = db.getCourses();
        for (Course c : all) {
            if (c.getName().equalsIgnoreCase(course.getName())) {
                throw new DataLayerException("Esiste già un nome con questo corso");
            }
        }
        course.setId(getNewId());
        all.add(course);
    }

    @Override
    public Course findCourseByName(String name) throws DataLayerException {
        List<Course> all = db.getCourses();
        for (Course c : all) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Course> findCourseByProfessor(Professor professor) throws DataLayerException {
        List<Course> all = db.getCourses(), out = new ArrayList<>();
        for (Course c : all) {
            if (c.getProfessor().equals(professor)) {
                out.add(c);
            }
        }
        return out;
    }

    @Override
    public List<Course> findAvailableCoursesForStudent(Student student) throws DataLayerException {
        ////corsi a cui non sei iscritto E del tuo corso di laurea
        List<Course> all = db.getCourses(), out = new ArrayList<>(db.getCourses());
        for (Course c : all) {
            if (c.getDegreeCourse().equals(student.getDegreeCourse())){
                for(Enrollment e:db.getEnrolling()){
                    if(e.getStudent().equals(student)){
                        out.remove(e.getCourse());
                    }
                }
            }else{
                out.remove(c);
            }
        }
        return out;
    }

    private Long getNewId() {
        long max = 0;
        for (Course c : db.getCourses()) {
            if (c.getId() >= max) {
                max = c.getId();
            }
        }
        return max + 1;
    }

}
