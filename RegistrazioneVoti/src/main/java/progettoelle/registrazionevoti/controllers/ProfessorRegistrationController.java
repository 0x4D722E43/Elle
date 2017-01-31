package progettoelle.registrazionevoti.controllers;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.omnifaces.util.Messages;
import progettoelle.registrazionevoti.domain.Faculty;
import progettoelle.registrazionevoti.mail.MailException;
import progettoelle.registrazionevoti.mail.MockEmailService;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.hibernate.FacultyRepositoryHibernate;
import progettoelle.registrazionevoti.repositories.hibernate.UserRepositoryHibernate;
import progettoelle.registrazionevoti.services.registration.RegisterProfessorService;
import progettoelle.registrazionevoti.services.ValidationException;

@ManagedBean
@RequestScoped
public class ProfessorRegistrationController {
    
    private final RegisterProfessorService service = new RegisterProfessorService(new FacultyRepositoryHibernate(), 
            new UserRepositoryHibernate(), new MockEmailService());
    
    private String email;
    private String name;
    private String surname;
    private Faculty selectedFaculty;
    private List<Faculty> availableFaculties;

    public ProfessorRegistrationController() {
    
    }
    
    @PostConstruct
    public void initialize() {
        try { 
            availableFaculties = service.getPossibleFaculties();
        } catch (DataLayerException ignored) { }
    }

    public String registerProfessor() {
        try {
            service.registerProfessor(email, name, surname, selectedFaculty);
            return "registration-success?faces-redirect=true";
        } catch (ValidationException ex) {
            Messages.addGlobalError(ex.getMessage());
            return "registration-professor";
        } catch (DataLayerException | MailException ex) {
            return "error?faces-redirect=true";
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

    public Faculty getSelectedFaculty() {
        return selectedFaculty;
    }

    public void setSelectedFaculty(Faculty selectedFaculty) {
        this.selectedFaculty = selectedFaculty;
    }

    public List<Faculty> getAvailableFaculties() {
        return availableFaculties;
    }

    public void setAvailableFaculties(List<Faculty> availableFaculties) {
        this.availableFaculties = availableFaculties;
    }
    
}
