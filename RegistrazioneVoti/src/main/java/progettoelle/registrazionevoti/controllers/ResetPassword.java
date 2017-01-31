package progettoelle.registrazionevoti.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.omnifaces.util.Messages;
import progettoelle.registrazionevoti.mail.MailException;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ServiceInjection;
import progettoelle.registrazionevoti.services.registration.ResetPasswordService;
import progettoelle.registrazionevoti.services.ValidationException;

@ManagedBean
@RequestScoped
public class ResetPassword {
    
    private final ResetPasswordService service = ServiceInjection.provideResetPasswordService();

    private String email;

    public ResetPassword() {
    
    }
    
    public String resetPassword() {
        try {
            service.resetPassword(email);
            return "reset-password-success";
        } catch (ValidationException ex) {
            Messages.addGlobalError(ex.getMessage());
            return "reset-password";
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
    
}
