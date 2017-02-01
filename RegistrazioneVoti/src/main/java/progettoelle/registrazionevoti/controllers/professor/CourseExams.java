package progettoelle.registrazionevoti.controllers.professor;

import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.Flash;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ServiceInjection;
import progettoelle.registrazionevoti.services.manageexam.OpenExamBookingsService;

@ManagedBean
@RequestScoped
public class CourseExams {
    
    private final OpenExamBookingsService service = ServiceInjection.provideOpenExamBookingsService();
    
    private Course course;
    private DataModel<Exam> exams;
    
    public CourseExams() {
        Flash flash = Faces.getFlash();
        course = (Course)flash.get("course");
        flash.keep("course");
    }
    
    @PostConstruct
    public void initialize() {
        try {
            List<Exam> results = service.getExams(course);
            exams = new ListDataModel<>(results);
        } catch (DataLayerException ex) {
            
        }
    }
    
    public String openExamBookings() {
        Exam exam = exams.getRowData();
        
        try {
            service.openExamBookings(exam);
            String title = "Iscrizioni aperte!";
            Messages.create(title).flash().add("growl");
            return "exams?faces-redirect=true";
        } catch (DataLayerException ex) {
            Messages.create("Oooops...").error().add("growl");
            return null;
        }
    }
        
    public String closeExamBookings() {
        Exam exam = exams.getRowData();
        
        try {
            service.closeExamBookings(exam);
            String title = "Iscrizioni chiuse!";
            Messages.create(title).flash().add("growl");
            return "exams?faces-redirect=true";
        } catch (DataLayerException ex) {
            Messages.create("Oooops...").error().add("growl");
            return null;
        }
    }
    
    public String redirectToExamResults(){
        Exam selectedExam = exams.getRowData();
        Faces.getFlash().put("exam", selectedExam);
        return "exam-results?faces-redirect=true";
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
    public DataModel<Exam> getExams() {
        return exams;
    }

    public void setExams(DataModel<Exam> exams) {
        this.exams = exams;
    }

}
