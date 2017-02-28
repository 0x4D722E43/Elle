package progettoelle.registrazionevoti.controllers.student;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.omnifaces.util.Messages;
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ServiceInjection;
import progettoelle.registrazionevoti.services.exams.LoadResultsHistoryService;

@ManagedBean
@RequestScoped
public class ExamResultHistory {
    
    private final LoadResultsHistoryService service = ServiceInjection.provideLoadExamResultHistoryService();
    
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
            Messages.addGlobalError("Ooops.. Qualcosa non ha funzionato");
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
