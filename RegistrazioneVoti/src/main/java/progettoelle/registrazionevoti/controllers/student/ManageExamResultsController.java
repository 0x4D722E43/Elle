package progettoelle.registrazionevoti.controllers.student;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.hibernate.EnrollmentRepositoryHibernate;
import progettoelle.registrazionevoti.repositories.hibernate.ExamResultRepositoryHibernate;
import progettoelle.registrazionevoti.services.manageexam.AcceptExamResultService;

@ManagedBean
@RequestScoped
public class ManageExamResultsController {
    
    private final AcceptExamResultService service = new AcceptExamResultService(new ExamResultRepositoryHibernate(), new EnrollmentRepositoryHibernate());
    
    @ManagedProperty(value="#{studentSession.student}")
    private Student student;
    private DataModel<ExamResult> examResults;

    public ManageExamResultsController() {
    
    }
    
    @PostConstruct
    public void initialize() {
        try {
            List<ExamResult> results = service.getExamsResults(student);
            examResults = new ListDataModel<>(results);
        } catch (DataLayerException ex) {
            
        }
    }
    
    public String acceptResult() {
        ExamResult selectedExamResult = examResults.getRowData();
        try { 
            service.acceptExamResult(student, selectedExamResult);
            return "success?faces-redirect=true";
        } catch (DataLayerException ex) {
            return "error?faces-redirect=true";
        }
    }
    
    public String rejectResult() {
        ExamResult selectedExamResult = examResults.getRowData();
        try { 
            service.rejectExamResult(student, selectedExamResult);
            return "success?faces-redirect=true";
        } catch (DataLayerException ex) {
            return "error?faces-redirect=true";
        }
    }
    
    public String aknowledgeFailedExam() {
        ExamResult selectedExamResult = examResults.getRowData();
        try { 
            service.acknowledgeFailedExam(student, selectedExamResult);
            return "success?faces-redirect=true";
        } catch (DataLayerException ex) {
            return "error?faces-redirect=true";
        }
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public DataModel<ExamResult> getExamResults() {
        return examResults;
    }

    public void setExamResults(DataModel<ExamResult> examResults) {
        this.examResults = examResults;
    }
    
}
