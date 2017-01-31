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
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.hibernate.ExamResultRepositoryHibernate;
import progettoelle.registrazionevoti.services.manageexam.ManageExamBookingsService;

@ManagedBean
@RequestScoped
public class ManageBookingsController {

    private final ManageExamBookingsService service = new ManageExamBookingsService(new ExamResultRepositoryHibernate());
    
    @ManagedProperty(value="#{studentSession.student}")
    private Student student;
    private DataModel<ExamResult> bookedExams;

    public ManageBookingsController() {
    
    }
    
    @PostConstruct
    public void initialize() {
        try {
            List<ExamResult> results = service.getExamBookings(student);
            bookedExams = new ListDataModel<>(results);
        } catch (DataLayerException ex) {
            Logger.getLogger(StudentNewCourse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String cancelBooking() {
        ExamResult selectedBooking = bookedExams.getRowData();
        try {
            service.cancelExamBooking(selectedBooking);
            return "success?faces-redirect=true";
        } catch (DataLayerException ex) {
            Logger.getLogger(BookExamController.class.getName()).log(Level.SEVERE, null, ex);
            return "error?faces-redirect=true";
        }
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public DataModel<ExamResult> getBookedExams() {
        return bookedExams;
    }

    public void setBookedExams(DataModel<ExamResult> bookedExams) {
        this.bookedExams = bookedExams;
    }
    
}
