package progettoelle.registrazionevoti.controllers.professor;

import java.io.Serializable;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ServiceInjection;
import progettoelle.registrazionevoti.services.account.UserAccountService;

@ManagedBean
@SessionScoped
public class ProfessorManager implements Serializable {

    private static final long serialVersionUID = -2101607539063388390L;
    
    private final UserAccountService service = ServiceInjection.provideUserAccountService();
    
    private Professor professor;
   
    public ProfessorManager() {
    
    }
    
    @PostConstruct
    public void initializeSession() {
        String email = Faces.getRemoteUser();
        
        try {
            professor = (Professor)service.getUser(email);
        } catch (DataLayerException ex) {
            
        }
    }
    
    public void updateProfessorInfo() {
        try {
            service.updateUserInfo(professor);
            Messages.create("Modifiche salvate!").add("growl");
        } catch (DataLayerException ex) {
            
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(professor.getId());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        final ProfessorManager other = (ProfessorManager) obj;
        if (!Objects.equals(professor.getId(), other.professor.getId())) return false;
        
        return true;
    }
    
}
