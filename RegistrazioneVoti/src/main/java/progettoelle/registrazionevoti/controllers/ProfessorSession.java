package progettoelle.registrazionevoti.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.user.UserRepositoryHibernate;
import progettoelle.registrazionevoti.services.UserSessionService;

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
        } catch (DataLayerException ex) {
            Logger.getLogger(StudentSession.class.getName()).log(Level.SEVERE, null, ex);
        }
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
