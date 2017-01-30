package progettoelle.registrazionevoti.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.omnifaces.util.Messages;
import progettoelle.registrazionevoti.mail.MailException;
import progettoelle.registrazionevoti.mail.MockEmailService;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.hibernate.UserRepositoryHibernate;
import progettoelle.registrazionevoti.services.ResetPasswordService;
import progettoelle.registrazionevoti.services.ValidationException;

@ManagedBean
@RequestScoped
public class ResetPasswordController {
    
    private final ResetPasswordService service = new ResetPasswordService(new UserRepositoryHibernate(), new MockEmailService());

    private String email;

    public ResetPasswordController() {
    
    }
    
    public String resetPassword() {
        try {
            service.resetPassword(email);
        } catch (ValidationException ex) {
            Messages.addGlobalError(ex.getMessage());
        } catch (DataLayerException | MailException ex) {
            
        }
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
