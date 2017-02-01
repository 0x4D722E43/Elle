package progettoelle.registrazionevoti.controllers.professor;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.omnifaces.util.Faces;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ServiceInjection;
import progettoelle.registrazionevoti.services.managecourse.LoadEnrolledStudentsService;

@ManagedBean
@RequestScoped
public class CourseEnrolledStudents {
    
    private final LoadEnrolledStudentsService service = ServiceInjection.provideLoadEnrolledStudentsService();
    
    private Course course = Faces.getFlashAttribute(Course.class.getName());
    private DataModel<Student> enrolledStudents;

    public CourseEnrolledStudents() {
    
    }
    
    @PostConstruct
    public void initialize() {
        try {
            List<Student> results = service.getEnrolledStudents(course);
            enrolledStudents = new ListDataModel<>(results);
        } catch (DataLayerException ex) {
            
        }
        
        Faces.getFlash().keep(Course.class.getName()); 
    }
    
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
    public DataModel<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(DataModel<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

}
