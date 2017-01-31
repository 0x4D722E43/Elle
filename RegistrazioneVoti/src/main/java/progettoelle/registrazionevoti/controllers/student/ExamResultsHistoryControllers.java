package progettoelle.registrazionevoti.controllers.student;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.hibernate.ExamResultRepositoryHibernate;
import progettoelle.registrazionevoti.services.manageexam.ManageExamResultsHistory;

@ManagedBean
@RequestScoped
public class ExamResultsHistoryControllers {
    
    private final ManageExamResultsHistory service = new ManageExamResultsHistory(new ExamResultRepositoryHibernate());
    
    @ManagedProperty(value="#{studentSession.student}")
    private Student student;
    private List<ExamResult> examResults;

    public ExamResultsHistoryControllers() {
    
    }

    @PostConstruct
    public void initialize() {
        try {
            examResults = service.getExamResultHistory(student);
        } catch (DataLayerException ex) {
            
        }
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<ExamResult> getExamResults() {
        return examResults;
    }

    public void setExamResults(List<ExamResult> examResults) {
        this.examResults = examResults;
    }
    
}
