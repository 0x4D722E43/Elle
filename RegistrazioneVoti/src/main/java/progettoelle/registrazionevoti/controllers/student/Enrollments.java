package progettoelle.registrazionevoti.controllers.student;

import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.omnifaces.util.Faces;
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

    @ManagedProperty(value="#{studentSession.student}")
    private Student student;
    
    public Enrollments() {
    
    }

    @PostConstruct
    public void initialize() throws IOException {
        try {
            enrollments = service.getEnrollments(student);
        } catch (DataLayerException ex) { 
            Faces.redirect("error.xhtml");
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
