package progettoelle.registrazionevoti.controllers.professor;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ServiceInjection;
import progettoelle.registrazionevoti.services.exams.OpenExamBookingsService;

@ManagedBean
@RequestScoped
public class CourseExams {
    
    private final OpenExamBookingsService service = ServiceInjection.provideOpenExamBookingsService();
    
    private Course course = Faces.getFlashAttribute(Course.class.getName());
    private DataModel<Exam> exams;
    
    public CourseExams() {
        
    }
    
    @PostConstruct
    public void initialize() {
        try {
            List<Exam> results = service.getExams(course);
            exams = new ListDataModel<>(results);
        } catch (DataLayerException ex) {
            
        }
        
        Faces.getFlash().keep(Course.class.getName());
    }
    
    public String openExamBookings() {
        Exam selectedExam = exams.getRowData();
        
        try {
            service.openExamBookings(selectedExam);
            String title = "Iscrizioni aperte!";
            Messages.create(title).flash().add("growl");
            return "exams?faces-redirect=true";
        } catch (DataLayerException ex) {
            Messages.create("Oooops...").error().add("growl");
            return null;
        }
    }
        
    public String closeExamBookings() {
        Exam selectedExam = exams.getRowData();
        
        try {
            service.closeExamBookings(selectedExam);
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
