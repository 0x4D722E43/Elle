package progettoelle.registrazionevoti.controllers;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.omnifaces.util.Messages;
import progettoelle.registrazionevoti.domain.DegreeCourse;
import progettoelle.registrazionevoti.mail.MailException;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ServiceInjection;
import progettoelle.registrazionevoti.services.registration.RegisterStudentService;
import progettoelle.registrazionevoti.services.ValidationException;

@ManagedBean
@RequestScoped
public class StudentRegistration {
    
    private final RegisterStudentService service = ServiceInjection.provideRegisterStudentService();

    private String email;
    private String name;
    private String surname;
    private String matriculationNumber;
    private DegreeCourse selectedDegreeCourse;
    private List<DegreeCourse> availableDegreeCourses;

    public StudentRegistration() {

    }

    @PostConstruct
    public void initialize() {
        try { 
            availableDegreeCourses = service.getPossibleDegreeCourses();
        } catch (DataLayerException ex) {
            Messages.create("Ooooops...").error().add("growl");
        }
    }

    public String registerStudent() {
        try {
            service.registerStudent(email, name, surname, matriculationNumber, selectedDegreeCourse);
            String title = "Registrazione effettuata!";
            String detail = "Ti abbiamo inviato una email contenente la password necessaria per autenticarti";
            Messages.create(title).detail(detail).flash().add();
            return "index?faces-redirect=true";
        } catch (ValidationException ex) {
            Messages.create(ex.getMessage()).error().add("validation");
            return "registration-student";
        } catch (DataLayerException | MailException ex) {
            Messages.create("Ooooops...").error().add("growl");
            return "registration-student";
        }
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMatriculationNumber() {
        return matriculationNumber;
    }

    public void setMatriculationNumber(String matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }

    public DegreeCourse getSelectedDegreeCourse() {
        return selectedDegreeCourse;
    }

    public void setSelectedDegreeCourse(DegreeCourse selectedDegreeCourse) {
        this.selectedDegreeCourse = selectedDegreeCourse;
    }

    public List<DegreeCourse> getAvailableDegreeCourses() {
        return availableDegreeCourses;
    }

    public void setAvailableDegreeCourses(List<DegreeCourse> availableDegreeCourses) {
        this.availableDegreeCourses = availableDegreeCourses;
    }
    
}
