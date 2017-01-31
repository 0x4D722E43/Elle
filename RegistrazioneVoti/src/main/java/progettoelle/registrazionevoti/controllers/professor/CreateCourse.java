package progettoelle.registrazionevoti.controllers.professor;

import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import progettoelle.registrazionevoti.domain.DegreeCourse;
import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ServiceInjection;
import progettoelle.registrazionevoti.services.managecourse.CreateCourseService;
import progettoelle.registrazionevoti.services.ValidationException;

@ManagedBean
@RequestScoped
public class CreateCourse {

    private final CreateCourseService service = ServiceInjection.provideCreateCourseService();
    
    private String name;
    private int credits;
    private DegreeCourse selectedDegreeCourse;
    private List<DegreeCourse> availableDegreeCourses;

    @ManagedProperty(value="#{professorManager.professor}")
    private Professor professor;
    
    public CreateCourse() {
    
    }
    
    @PostConstruct
    public void initialize() {
        try {
            availableDegreeCourses = service.getPossibleDegreeCourses();
        } catch (DataLayerException ex) {
            
        }
    }
    
    public String createCourse() {
        try {
            service.createCourse(name, credits, professor, selectedDegreeCourse);
            return "success?faces-redirect=true";
        } catch (ValidationException ex) {
            Messages.addGlobalError(ex.getMessage());
            return "create-course";
        } catch (DataLayerException ex) {
            return "error?faces-redirect=true";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public DegreeCourse getSelectedDegreeCourse() {
        return selectedDegreeCourse;
    }

    public void setSelectedDegreeCourse(DegreeCourse selectedDegreeCourse) {
        this.selectedDegreeCourse = selectedDegreeCourse;
    }

    public List<DegreeCourse> getAvailableDegreeCourses() {
        return availableDegreeCourses;
    }

    public void setAvailableDegreeCourses(List<DegreeCourse> availableDegreeCourses) {
        this.availableDegreeCourses = availableDegreeCourses;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

}
