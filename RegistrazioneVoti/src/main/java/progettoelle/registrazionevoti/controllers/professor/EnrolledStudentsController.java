package progettoelle.registrazionevoti.controllers.professor;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.Flash;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.hibernate.EnrollmentRepositoryHibernate;
import progettoelle.registrazionevoti.services.ManageEnrolledStudentsService;

@ManagedBean
@RequestScoped
public class EnrolledStudentsController {
    
    private final ManageEnrolledStudentsService service = new ManageEnrolledStudentsService(new EnrollmentRepositoryHibernate());
    
    @ManagedProperty(value = "#{flash}")
    private Flash flash;
    private DataModel<Student> enrolledStudents;

    public EnrolledStudentsController() {
    
    }
    
    @PostConstruct
    public void initialize() {
        try {
            Course course = (Course)flash.get("course");
            flash.keep("course");
            List<Student> results = service.getEnrolledStudents(course);
            enrolledStudents = new ListDataModel<>(results);
        } catch (DataLayerException ex) {
            
        }
    }

    public Flash getFlash() {
        return flash;
    }

    public void setFlash(Flash flash) {
        this.flash = flash;
    }

    public DataModel<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(DataModel<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }
    
}
