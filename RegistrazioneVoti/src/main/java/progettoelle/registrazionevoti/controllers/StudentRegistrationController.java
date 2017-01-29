package progettoelle.registrazionevoti.controllers;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import progettoelle.registrazionevoti.domain.DegreeCourse;
import progettoelle.registrazionevoti.mail.MailException;
import progettoelle.registrazionevoti.mail.MockEmailService;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.hibernate.DegreeCourseRepositoryHibernate;
import progettoelle.registrazionevoti.repositories.hibernate.FacultyRepositoryHibernate;
import progettoelle.registrazionevoti.repositories.hibernate.UserRepositoryHibernate;
import progettoelle.registrazionevoti.services.RegisterStudentService;
import progettoelle.registrazionevoti.services.ValidationException;

@ManagedBean
@RequestScoped
public class StudentRegistrationController {

    private RegisterStudentService service = new RegisterStudentService(new FacultyRepositoryHibernate(),
            new DegreeCourseRepositoryHibernate(), new UserRepositoryHibernate(), new MockEmailService());

    private String email;
    private String name;
    private String surname;
    private String matriculationNumber;
    private DegreeCourse selectedDegreeCourse;
    private List<DegreeCourse> availableDegreeCourses;

    public StudentRegistrationController() {

    }

    @PostConstruct
    public void initializeAvailableFaculties() {
        try {
            availableDegreeCourses = service.getPossibleDegreeCourses();
        } catch (DataLayerException ex) {
            Logger.getLogger(StudentRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String registerStudent() {
        try {
            service.registerStudent(email, name, surname, matriculationNumber, selectedDegreeCourse);
            
        } catch (ValidationException ex) {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Errore", ex.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            return null;
        } catch (DataLayerException ex) {
            Logger.getLogger(StudentRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (MailException ex) {
            Logger.getLogger(StudentRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "studentregister_confirmed?faces-redirect=true";
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
