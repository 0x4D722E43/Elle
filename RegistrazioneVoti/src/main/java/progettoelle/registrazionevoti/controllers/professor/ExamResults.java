package progettoelle.registrazionevoti.controllers.professor;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.Flash;
import org.omnifaces.util.Faces;
import org.primefaces.event.RowEditEvent;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ServiceInjection;
import progettoelle.registrazionevoti.services.manageexam.GradeExamService;

@ManagedBean
@ViewScoped
public class ExamResults implements Serializable {
    
    private final GradeExamService service = ServiceInjection.provideGradeExamService();
    
    private Exam exam = Faces.getFlashAttribute("exam");
    private List<ExamResult> examResults;
    
    public ExamResults() {
  
    }
    
    @PostConstruct
    private void initialize() {
        try {
            examResults = service.getExamResults(exam);
        } catch (DataLayerException ex) {
            
        }
        
        Flash flash = Faces.getFlash();
        flash.keep(Course.class.getName());
        flash.keep("exam");
    }
    
    public void onRowEdit(RowEditEvent event) {
        try {
            System.out.println("Value of Exam in the bean " + exam);
            System.out.println("Value of Exam int the flash " + Faces.getFlashAttribute("exam"));
            ExamResult examResult = (ExamResult)event.getObject();
            
            service.gradeExam(examResult.getGrade(), examResult);
        } catch (DataLayerException ex) {
            
        }
    }
    
    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }
    
    public List<ExamResult> getExamResults() {
        return examResults;
    }

    public void setExamResults(List<ExamResult> examResults) {
        this.examResults = examResults;
    }
    
}
