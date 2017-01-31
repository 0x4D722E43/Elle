package progettoelle.registrazionevoti.controllers.student;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.omnifaces.util.Faces;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ServiceInjection;
import progettoelle.registrazionevoti.services.account.UserAccountService;

@ManagedBean
@SessionScoped
public class StudentManager {
    
    private Student student;
    private final UserAccountService userSessionService = ServiceInjection.provideUserAccountService();
    
    public StudentManager(){
        
    }
    
    @PostConstruct
    public void initializeSession() {
        String email = Faces.getRemoteUser();
        
        try {
            student = (Student)userSessionService.getUser(email);
        } catch (DataLayerException ex) {
            
        }
    }
    
    public String logout() {
        Faces.invalidateSession();
        return "/index?faces-redirect=true";
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
