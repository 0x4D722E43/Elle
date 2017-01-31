package progettoelle.registrazionevoti.controllers.student;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.hibernate.ExamRepositoryHibernate;
import progettoelle.registrazionevoti.repositories.hibernate.ExamResultRepositoryHibernate;
import progettoelle.registrazionevoti.services.manageexam.BookExamService;

@ManagedBean
@RequestScoped
public class BookExam {

    private final BookExamService service = new BookExamService(new ExamRepositoryHibernate(), new ExamResultRepositoryHibernate());
    
    @ManagedProperty(value="#{studentSession.student}")
    private Student student;
    private DataModel<Exam> availableExams;
    
    public BookExam() {
    
    }
    
    @PostConstruct
    public void initialize() {
        try {
            List<Exam> exams = service.getBookableExams(student);
            availableExams = new ListDataModel<>(exams);
        } catch (DataLayerException ex) {
            Logger.getLogger(EnrollOnCourse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String bookExam() {
        Exam selectedExam = availableExams.getRowData();
        try {
            service.bookExam(student, selectedExam);
            return "success?faces-redirect=true";
        } catch (DataLayerException ex) {
            Logger.getLogger(BookExam.class.getName()).log(Level.SEVERE, null, ex);
            return "error?faces-redirect=true";
        }
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public DataModel<Exam> getAvailableExams() {
        return availableExams;
    }

    public void setAvailableExams(DataModel<Exam> availableExams) {
        this.availableExams = availableExams;
    }
    
}
