package progettoelle.registrazionevoti.controllers.student;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.hibernate.CourseRepositoryHibernate;
import progettoelle.registrazionevoti.repositories.hibernate.EnrollmentRepositoryHibernate;
import progettoelle.registrazionevoti.services.managecourse.EnrollOnCourseService;

@ManagedBean
@RequestScoped
public class EnrollOnCourse {
    
    private final EnrollOnCourseService service = new EnrollOnCourseService(new CourseRepositoryHibernate(), new EnrollmentRepositoryHibernate());
    
    @ManagedProperty(value="#{studentSession.student}")
    private Student student;
    private DataModel<Course> availableCourses;

    public EnrollOnCourse() {
    
    }
    
    @PostConstruct
    public void initialize() {
        try {
            List<Course> courses = service.getCoursesOnWhichStudentCanEnroll(student);
            availableCourses = new ListDataModel<>(courses);
        } catch (DataLayerException ex) {
            Logger.getLogger(EnrollOnCourse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String enrollOnCourse() {
        try {
            Course selectedCourse = availableCourses.getRowData();
            service.enrollOnCourse(student, selectedCourse);
            return "success?faces-redirect=true";
        } catch (DataLayerException ex) {
            Logger.getLogger(EnrollOnCourse.class.getName()).log(Level.SEVERE, null, ex);
            return "error?faces-redirect=true";
        }
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public DataModel<Course> getAvailableCourses() {
        return availableCourses;
    }

    public void setAvailableCourses(DataModel<Course> availableCourses) {
        this.availableCourses = availableCourses;
    }
    
}
