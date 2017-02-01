package progettoelle.registrazionevoti.controllers.student;

import java.io.Serializable;
import java.util.Objects;
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
public class StudentManager implements Serializable {

    private static final long serialVersionUID = 7384720692222530484L;
    
    private final UserAccountService userSessionService = ServiceInjection.provideUserAccountService();
    
    private Student student;
    
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.student.getId());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        
        final StudentManager other = (StudentManager) obj;
        if (!Objects.equals(this.student.getId(), other.student.getId())) return false;
        
        return true;
    }
    
}
