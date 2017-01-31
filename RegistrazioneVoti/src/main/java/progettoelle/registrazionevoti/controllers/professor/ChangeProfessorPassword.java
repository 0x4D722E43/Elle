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
    
    private String oldPassword;
    private String password;
    private String passwordConfirmation;
    
    @ManagedProperty(value = "#{professorManager.professor}")
    private Professor professor;

    public ChangeProfessorPassword() {
    
    }
    
    public String changePassword() {
        try {
            service.changePassword(professor, oldPassword, password, passwordConfirmation);
            return "success?faces-redirect=true";
        } catch (ValidationException ex) {
            Messages.addGlobalError(ex.getMessage());
            return "change-password";
        } catch (DataLayerException ex) {
            return "error?faces-redirect=true";
        }
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

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
}
