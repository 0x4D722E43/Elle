package progettoelle.registrazionevoti.controllers.professor;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.hibernate.ExamRepositoryHibernate;
import progettoelle.registrazionevoti.services.ManageExamsService;

@ManagedBean
@RequestScoped
public class ProfessorExamsController {
    
    private final ManageExamsService service = new ManageExamsService(new ExamRepositoryHibernate());
    
    @ManagedProperty(value = "#{flash}")
    private Flash flash;
    
    private DataModel<Exam> exams;

    public ProfessorExamsController() {
       
    }
    
    @PostConstruct
    public void initialize() {
        try {
            Course course = (Course)flash.get("course");
            flash.keep("course");
            List<Exam> results = service.getExams(course);
            exams = new ListDataModel<>(results);
        } catch (DataLayerException ex) {
            
        }
    }
    
    public String openExamBookings() {
        try {
            Exam exam = exams.getRowData();
            service.openExamBookings(exam);
            return "exams?faces-redirect=true";
        } catch (DataLayerException ex) {
            return "error?faces-redirect=true";
        }
    }
        
    public String closeExamBookings() {
        try {
            Exam exam = exams.getRowData();
            service.closeExamBookings(exam);
            return "exams?faces-redirect=true";
        } catch (DataLayerException ex) {
            return "error?faces-redirect=true";
        }
    }
    
    public String redirectToExamResults(){
        Exam selectedExam = exams.getRowData();
        flash.put("exam", selectedExam);
        return "exam-results?faces-redirect=true";
    }

    public DataModel<Exam> getExams() {
        return exams;
    }

    public void setExams(DataModel<Exam> exams) {
        this.exams = exams;
    }

    public Flash getFlash() {
        return flash;
    }

    public void setFlash(Flash flash) {
        this.flash = flash;
    }
    
}
