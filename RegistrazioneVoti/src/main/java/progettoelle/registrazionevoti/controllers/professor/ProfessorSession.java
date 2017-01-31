package progettoelle.registrazionevoti.controllers.professor;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.hibernate.UserRepositoryHibernate;
import progettoelle.registrazionevoti.services.account.UserSessionService;

@ManagedBean
@SessionScoped
public class ProfessorSession {

    private Professor professor;
    private final UserSessionService userSessionService = new UserSessionService(new UserRepositoryHibernate());
    
    public ProfessorSession() {
    
    }
    
    @PostConstruct
    public void initializeSession() {
        String email = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        
        try {
            professor = (Professor)userSessionService.getUser(email);
        } catch (DataLayerException ignored) { }
    }
    
    public String logout() {
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        return "/index?faces-redirect=true";
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
}
