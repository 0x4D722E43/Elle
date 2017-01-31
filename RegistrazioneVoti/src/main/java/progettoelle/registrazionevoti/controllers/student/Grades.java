package progettoelle.registrazionevoti.controllers.student;

import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.omnifaces.util.Faces;
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ServiceInjection;
import progettoelle.registrazionevoti.services.manageexam.AcceptExamResultService;

@ManagedBean
@RequestScoped
public class Grades {
    
    private final AcceptExamResultService service = ServiceInjection.provideAcceptExamResultService();
    
    private DataModel<ExamResult> grades;
    
    @ManagedProperty(value="#{studentManager.student}")
    private Student student;

    public Grades() {
    
    }
    
    @PostConstruct
    public void initialize() throws IOException {
        try {
            List<ExamResult> results = service.getExamsResults(student);
            grades = new ListDataModel<>(results);
        } catch (DataLayerException ex) {
            Faces.redirect("error.xhtml");
        }
    }
    
    public String acceptResult() {
        ExamResult selectedExamResult = grades.getRowData();
        
        try { 
            service.acceptExamResult(student, selectedExamResult);
            return "success?faces-redirect=true";
        } catch (DataLayerException ex) {
            return "error?faces-redirect=true";
        }
    }
    
    public String rejectResult() {
        ExamResult selectedExamResult = grades.getRowData();
        
        try { 
            service.rejectExamResult(student, selectedExamResult);
            return "success?faces-redirect=true";
        } catch (DataLayerException ex) {
            return "error?faces-redirect=true";
        }
    }
    
    public String aknowledgeFailedExam() {
        ExamResult selectedExamResult = grades.getRowData();
        
        try { 
            service.acknowledgeFailedExam(student, selectedExamResult);
            return "success?faces-redirect=true";
        } catch (DataLayerException ex) {
            return "error?faces-redirect=true";
        }
    }

    public DataModel<ExamResult> getGrades() {
        return grades;
    }

    public void setGrades(DataModel<ExamResult> grades) {
        this.grades = grades;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
