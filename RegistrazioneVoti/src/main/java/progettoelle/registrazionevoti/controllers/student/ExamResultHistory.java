package progettoelle.registrazionevoti.controllers.student;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ServiceInjection;
import progettoelle.registrazionevoti.services.manageexam.LoadExamResultHistoryService;

@ManagedBean
@RequestScoped
public class ExamResultHistory {
    
    private final LoadExamResultHistoryService service = ServiceInjection.provideLoadExamResultHistoryService();
    
    private List<ExamResult> examResults;

    @ManagedProperty(value="#{studentManager.student}")
    private Student student;
    
    public ExamResultHistory() {
    
    }

    @PostConstruct
    public void initialize() {
        try {
            examResults = service.getExamResultHistory(student);
        } catch (DataLayerException ex) {
            
        }
    }

    public List<ExamResult> getExamResults() {
        return examResults;
    }

    public void setExamResults(List<ExamResult> examResults) {
        this.examResults = examResults;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
