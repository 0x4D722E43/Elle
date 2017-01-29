package progettoelle.registrazionevoti.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.hibernate.UserRepositoryHibernate;
import progettoelle.registrazionevoti.services.UserSessionService;

@ManagedBean
@SessionScoped
public class StudentSession {
    
    private Student student;
    private final UserSessionService userSessionService = new UserSessionService(new UserRepositoryHibernate());
    
    public StudentSession(){
        
    }
    
    @PostConstruct
    public void initializeSession() {
        String email = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        try {
            student = (Student)userSessionService.getUser(email);
        } catch (DataLayerException ex) {
            Logger.getLogger(StudentSession.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String logout() {
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        return "/index?faces-redirect=true";
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
