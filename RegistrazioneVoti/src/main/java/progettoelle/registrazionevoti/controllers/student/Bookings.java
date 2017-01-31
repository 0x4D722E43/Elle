package progettoelle.registrazionevoti.controllers.student;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import progettoelle.registrazionevoti.services.manageexam.ManageExamBookingsService;

@ManagedBean
@RequestScoped
public class Bookings {

    private final ManageExamBookingsService service = ServiceInjection.provideManageExamBookingsService();
    
    private DataModel<ExamResult> bookedExams;

    @ManagedProperty(value="#{studentManager.student}")
    private Student student;
    
    public Bookings() {
    
    }
    
    @PostConstruct
    public void initialize() {
        try {
            List<ExamResult> results = service.getExamBookings(student);
            bookedExams = new ListDataModel<>(results);
        } catch (DataLayerException ex) {
            
        }
    }
    
    public String cancelBooking() {
        ExamResult selectedBooking = bookedExams.getRowData();
        
        try {
            service.cancelExamBooking(selectedBooking);
            return "success?faces-redirect=true";
        } catch (DataLayerException ex) {
            return "error?faces-redirect=true";
        }
    }

    public DataModel<ExamResult> getBookedExams() {
        return bookedExams;
    }

    public void setBookedExams(DataModel<ExamResult> bookedExams) {
        this.bookedExams = bookedExams;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
