package progettoelle.registrazionevoti.controllers.student;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
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
            Messages.addGlobalError("Ooops.. Qualcosa non ha funzionato");
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
