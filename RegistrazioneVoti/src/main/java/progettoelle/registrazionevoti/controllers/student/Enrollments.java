package progettoelle.registrazionevoti.controllers.student;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.omnifaces.util.Messages;
import progettoelle.registrazionevoti.domain.Enrollment;
import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ServiceInjection;
import progettoelle.registrazionevoti.services.managecourse.EnrollmentsService;

@ManagedBean
@RequestScoped
public class Enrollments {
    
    private final EnrollmentsService service = ServiceInjection.provideEnrollmentService();
    
    private DataModel<Enrollment> enrollments;
    private Professor selectedProfessor;
    
    @ManagedProperty(value="#{studentManager.student}")
    private Student student;
    
    public Enrollments() {
    
    }

    @PostConstruct
    public void initialize() {
        try {
            List<Enrollment> results = service.getEnrollments(student);
            enrollments = new ListDataModel<>(results);
        } catch (DataLayerException ex) { 
            Messages.addGlobalError("Ooops.. Qualcosa non ha funzionato");
        }
    }
    
    public DataModel<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(DataModel<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public Professor getSelectedProfessor() {
        return selectedProfessor;
    }

    public void setSelectedProfessor(Professor selectedProfessor) {
        this.selectedProfessor = selectedProfessor;
    }
    
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
