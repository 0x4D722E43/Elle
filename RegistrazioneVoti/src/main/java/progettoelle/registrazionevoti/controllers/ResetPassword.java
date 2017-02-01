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
            String title = "Password Resettata!";
            String detail = "Ti abbiamo inviato la nuova password via mail";
            Messages.create(title).detail(detail).flash().add();
            return "index?faces-redirect=true";
        } catch (ValidationException ex) {
            Messages.create(ex.getMessage()).error().add("validation");
            return null;
        } catch (DataLayerException | MailException ex) {
            Messages.create("Ooooops...").error().add("growl");
            return null;
        }
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
