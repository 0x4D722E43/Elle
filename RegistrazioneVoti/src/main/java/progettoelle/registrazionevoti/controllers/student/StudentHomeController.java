package progettoelle.registrazionevoti.controllers.student;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import progettoelle.registrazionevoti.domain.Enrollment;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.hibernate.EnrollmentRepositoryHibernate;
import progettoelle.registrazionevoti.services.managecourse.LoadStudentEnrollmentsService;

@ManagedBean
@RequestScoped
public class StudentHomeController {
    
    private final LoadStudentEnrollmentsService service = new LoadStudentEnrollmentsService(new EnrollmentRepositoryHibernate());
    
    @ManagedProperty(value="#{studentSession.student}")
    private Student student;
    private List<Enrollment> enrollments;

    public StudentHomeController() {
    }

    @PostConstruct
    public void initialize() {
        try {
            enrollments = service.getEnrollments(student);
        } catch (DataLayerException ignored) { }
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
