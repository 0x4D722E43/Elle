package progettoelle.registrazionevoti.controllers.professor;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.omnifaces.util.Faces;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ServiceInjection;
import progettoelle.registrazionevoti.services.manageexam.CreateExamService;

@ManagedBean
@RequestScoped
public class CreateExam {
    
    private final CreateExamService service = ServiceInjection.provideCreateExamService();
    
    private Date date;
    private String room;
    private String description;
    private Course selectedCourse;
    private List<Course> availableCourses;
    
    @ManagedProperty(value="#{professorManager.professor}")
    private Professor professor;

    public CreateExam() {
    
    }

    @PostConstruct
    public void initialize() {
        try {
            availableCourses = service.getPossibleCourses(professor);
        } catch (DataLayerException ex) {
            
        }
    }
    
    public String createExam() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            service.createExam(selectedCourse, calendar, room, description);
            return "success?faces-redirect=true";
        } catch (DataLayerException ex) {
            return "error?faces-redirect=true";
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getSelectedCourse() {
        return selectedCourse;
    }

    public void setSelectedCourse(Course selectedCourse) {
        this.selectedCourse = selectedCourse;
    }

    public List<Course> getAvailableCourses() {
        return availableCourses;
    }

    public void setAvailableCourses(List<Course> availableCourses) {
        this.availableCourses = availableCourses;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

}
