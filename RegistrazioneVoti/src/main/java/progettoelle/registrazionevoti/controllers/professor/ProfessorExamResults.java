package progettoelle.registrazionevoti.controllers.professor;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.Flash;
import org.primefaces.event.RowEditEvent;
import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.hibernate.ExamResultRepositoryHibernate;
import progettoelle.registrazionevoti.services.GradeExamService;
import progettoelle.registrazionevoti.services.ValidationException;

@ManagedBean
@ViewScoped
public class ProfessorExamResults {
    
    private final GradeExamService service = new GradeExamService(new ExamResultRepositoryHibernate());
    
    @ManagedProperty(value = "#{flash}")
    private Flash flash;
    private List<ExamResult> examResults;

    public ProfessorExamResults() {
    
    }
    
    @PostConstruct
    private void initialize() {
        try {
            Exam exam = (Exam)flash.get("exam");
            flash.keep("exam");
            examResults = service.getExamResults(exam);
        } catch (DataLayerException ex) {
            
        }
    }
    
    public void onRowEdit(RowEditEvent event) {
        try {
            ExamResult examResult = (ExamResult)event.getObject();
            service.gradeExam(examResult.getGrade(), examResult);
        } catch (ValidationException ex) {
            Logger.getLogger(ProfessorExamResults.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DataLayerException ex) {
            Logger.getLogger(ProfessorExamResults.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Flash getFlash() {
        return flash;
    }

    public void setFlash(Flash flash) {
        this.flash = flash;
    }

    public List<ExamResult> getExamResults() {
        return examResults;
    }

    public void setExamResults(List<ExamResult> examResults) {
        this.examResults = examResults;
    }

    
    
    
    
    
}
