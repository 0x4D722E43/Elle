package progettoelle.registrazionevoti.controllers.professor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.omnifaces.util.Messages;
import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ServiceInjection;
import progettoelle.registrazionevoti.services.ValidationException;
import progettoelle.registrazionevoti.services.account.ChangePasswordService;

@ManagedBean
@RequestScoped
public class ChangeProfessorPassword {
    
    private final ChangePasswordService service = ServiceInjection.provideChangePasswordService();
    
    @ManagedProperty(value = "#{professorManager.professor}")
    private Professor professor;
    
    private String oldPassword;
    private String password;
    private String passwordConfirmation;
    
    public ChangeProfessorPassword() {
    
    }
    
    public String changePassword() {
        try {
            service.changePassword(professor, oldPassword, password, passwordConfirmation);
            String title = "Password cambiata!";
            Messages.create(title).flash().add("growl");
            return "change-password?faces-redirect=true";
        } catch (ValidationException ex) {
            Messages.create(ex.getMessage()).error().add("validation");
            return null;
        } catch (DataLayerException ex) {
            Messages.create("Oooops...").add("growl");
            return null;
        }
    }
    
    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

}
