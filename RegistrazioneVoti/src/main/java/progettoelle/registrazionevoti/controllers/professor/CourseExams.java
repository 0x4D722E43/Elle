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
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ServiceInjection;
import progettoelle.registrazionevoti.services.manageexam.OpenExamBookingsService;

@ManagedBean
@RequestScoped
public class CourseExams {
    
    private final OpenExamBookingsService service = ServiceInjection.provideOpenExamBookingsService();
    
    private DataModel<Exam> exams;
    
    public CourseExams() {
       
    }
    
    @PostConstruct
    public void initialize() throws IOException {
        Flash flash = Faces.getFlash();
        Course course = (Course)flash.get("course");
        flash.keep("course");
        
        try {
            List<Exam> results = service.getExams(course);
            exams = new ListDataModel<>(results);
        } catch (DataLayerException ex) {
            Faces.redirect("error.xhtml");
        }
    }
    
    public String openExamBookings() {
        Exam exam = exams.getRowData();
        
        try {
            service.openExamBookings(exam);
            return "exams?faces-redirect=true";
        } catch (DataLayerException ex) {
            return "error?faces-redirect=true";
        }
    }
        
    public String closeExamBookings() {
        Exam exam = exams.getRowData();
        
        try {
            service.closeExamBookings(exam);
            return "exams?faces-redirect=true";
        } catch (DataLayerException ex) {
            return "error?faces-redirect=true";
        }
    }
    
    public String redirectToExamResults(){
        Exam selectedExam = exams.getRowData();
        Faces.getFlash().put("exam", selectedExam);
        return "exam-results?faces-redirect=true";
    }

    public DataModel<Exam> getExams() {
        return exams;
    }

    public void setExams(DataModel<Exam> exams) {
        this.exams = exams;
    }

}
