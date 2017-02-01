package progettoelle.registrazionevoti.controllers.student;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.omnifaces.util.Messages;
import progettoelle.registrazionevoti.domain.Enrollment;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ServiceInjection;
import progettoelle.registrazionevoti.services.managecourse.LoadStudentEnrollmentsService;

@ManagedBean
@RequestScoped
public class Enrollments {
    
    private final LoadStudentEnrollmentsService service = ServiceInjection.provideLoadStudentEnrollmentsService();
    
    private List<Enrollment> enrollments;

    @ManagedProperty(value="#{studentManager.student}")
    private Student student;
    
    public Enrollments() {
    
    }

    @PostConstruct
    public void initialize() {
        try {
            enrollments = service.getEnrollments(student);
        } catch (DataLayerException ex) { 
            Messages.addGlobalError("Ooops.. Qualcosa non ha funzionato");
        }
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
