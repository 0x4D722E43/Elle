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
import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ServiceInjection;
import progettoelle.registrazionevoti.services.manageexam.BookExamService;

@ManagedBean
@RequestScoped
public class BookExam {

    private final BookExamService service = ServiceInjection.provideBookExamService();
    
    private DataModel<Exam> availableExams;
    
    @ManagedProperty(value="#{studentManager.student}")
    private Student student;
    
    public BookExam() {
    
    }
    
    @PostConstruct
    public void initialize() {
        try {
            List<Exam> exams = service.getBookableExams(student);
            availableExams = new ListDataModel<>(exams);
        } catch (DataLayerException ex) {
            
        }
    }
    
    public String bookExam() {
        Exam selectedExam = availableExams.getRowData();
        
        try {
            service.bookExam(student, selectedExam);
            return "success?faces-redirect=true";
        } catch (DataLayerException ex) {
            return "error?faces-redirect=true";
        }
    }

    public DataModel<Exam> getAvailableExams() {
        return availableExams;
    }

    public void setAvailableExams(DataModel<Exam> availableExams) {
        this.availableExams = availableExams;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
}
