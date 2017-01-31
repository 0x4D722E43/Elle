package progettoelle.registrazionevoti.controllers.student;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.omnifaces.util.Messages;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ServiceInjection;
import progettoelle.registrazionevoti.services.ValidationException;
import progettoelle.registrazionevoti.services.account.ChangePasswordService;

@ManagedBean
@RequestScoped
public class ChangeStudentPassword {
    
    private final ChangePasswordService service = ServiceInjection.provideChangePasswordService();
    
    private String oldPassword;
    private String password;
    private String passwordConfirmation;
    
    @ManagedProperty(value = "#{studentManager.student}")
    private Student student;

    public ChangeStudentPassword() {
    }

    public String changePassword() {
        try {
            service.changePassword(student, oldPassword, password, passwordConfirmation);
            Messages.addFlashGlobalInfo("Password cambiata con successo");
            return "change-password?faces-redirect=true";
        } catch (ValidationException ex) {
            Messages.addGlobalError(ex.getMessage());
            return "change-password";
        } catch (DataLayerException ex) {
            Messages.addGlobalError("Ooops.. Qualcosa non ha funzionato");
            return "change-password";
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
