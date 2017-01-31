package progettoelle.registrazionevoti.controllers.professor;

import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.omnifaces.util.Faces;
import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ServiceInjection;
import progettoelle.registrazionevoti.services.account.UserAccountService;

@ManagedBean
@SessionScoped
public class ProfessorManager {
    
    private final UserAccountService service = ServiceInjection.provideUserAccountService();
    
    private Professor professor;
   
    public ProfessorManager() {
    
    }
    
    @PostConstruct
    public void initializeSession() throws IOException {
        String email = Faces.getRemoteUser();
        
        try {
            professor = (Professor)service.getUser(email);
        } catch (DataLayerException ex) {
            Faces.redirect("error.xhtml");
        }
    }
    
    public String logout() {
        Faces.invalidateSession();
        return "/index?faces-redirect=true";
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
}
