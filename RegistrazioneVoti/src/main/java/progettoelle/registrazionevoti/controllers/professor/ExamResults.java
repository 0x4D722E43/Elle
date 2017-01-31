package progettoelle.registrazionevoti.controllers.professor;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.Flash;
import org.omnifaces.util.Faces;
import org.primefaces.event.RowEditEvent;
import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ServiceInjection;
import progettoelle.registrazionevoti.services.manageexam.GradeExamService;

@ManagedBean
@ViewScoped
public class ExamResults {
    
    private final GradeExamService service = ServiceInjection.provideGradeExamService();
    
    private List<ExamResult> examResults;
    
    public ExamResults() {
    
    }
    
    @PostConstruct
    private void initialize() {
        Flash flash = Faces.getFlash();
        Exam exam = (Exam)flash.get("exam");
        flash.keep("exam");
        
        try {
            examResults = service.getExamResults(exam);
        } catch (DataLayerException ex) {
            
        }
    }
    
    public void onRowEdit(RowEditEvent event) {
        try {
            ExamResult examResult = (ExamResult)event.getObject();
            service.gradeExam(examResult.getGrade(), examResult);
        } catch (DataLayerException ex) {
            
        }
    }

    public List<ExamResult> getExamResults() {
        return examResults;
    }

    public void setExamResults(List<ExamResult> examResults) {
        this.examResults = examResults;
    }

}
