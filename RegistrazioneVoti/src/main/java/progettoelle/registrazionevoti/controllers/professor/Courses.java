package progettoelle.registrazionevoti.controllers.professor;

import java.io.IOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.omnifaces.util.Faces;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ServiceInjection;
import progettoelle.registrazionevoti.services.managecourse.LoadProfessorCoursesService;

@ManagedBean
@RequestScoped
public class Courses {
    
    private final LoadProfessorCoursesService service = ServiceInjection.provideLoadProfessorCoursesService();
    
    private DataModel<Course> courses;

    @ManagedProperty(value = "#{professorManager.professor}")
    private Professor professor;
    
    public Courses() {
    
    }
    
    @PostConstruct
    public void initialize() throws IOException {
        try {
            List<Course> results = service.getCourses(professor);
            courses = new ListDataModel<>(results);
        } catch (DataLayerException ex) { 
            Faces.redirect("error.xhtml");
        }
    }
    
    public String redirectToCourseExams(){
        saveSelectedCourseToFlash();
        return "exams?faces-redirect=true";
    }
    
    public String redirectToCourseEnrolledStudents(){
        saveSelectedCourseToFlash();
        return "students?faces-redirect=true";
    }
    
    private void saveSelectedCourseToFlash() {
        Course selectedCourse = courses.getRowData();
        Faces.getFlash().put("course", selectedCourse);
    }

    public DataModel<Course> getCourses() {
        return courses;
    }

    public void setCourses(DataModel<Course> courses) {
        this.courses = courses;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

}
