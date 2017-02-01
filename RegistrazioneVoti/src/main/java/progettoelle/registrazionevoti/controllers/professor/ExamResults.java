package progettoelle.registrazionevoti.controllers.professor;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
public class ExamResults {
    
    private final GradeExamService service = ServiceInjection.provideGradeExamService();
    
    @ManagedProperty(value ="#{flash['exam']}")
    private Exam exam;
    private List<ExamResult> examResults;
    
    public ExamResults() {
  
    }
    
    @PostConstruct
    private void initialize() {
        System.out.println("EXAM RESULT BEAN CALLED");
        try {
            examResults = service.getExamResults(exam);
        } catch (DataLayerException ex) {
            
        }
        System.out.println(Faces.getFlashAttribute("exam"));
        //keepFlashInfo(exam, exam.getCourse());
    }
    
    public void onRowEdit(RowEditEvent event) {
        try {
            System.out.println(exam);
            ExamResult examResult = (ExamResult)event.getObject();
            
            service.gradeExam(examResult.getGrade(), examResult);
        } catch (DataLayerException ex) {
            
        }
    }
    
    private void keepFlashInfo(Exam exam, Course course) {
        Flash flash = Faces.getFlash();
        flash.put("course", course);
        flash.keep("exam");
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
    
    @PreDestroy
    public void keepFlash() {
        System.out.println("PRE DESTROY CALLED " + Faces.getFlashAttribute("exam"));
        
        Faces.getFlash().keep("exam");
    }

}
