package progettoelle.registrazionevoti.controllers.professor;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.hibernate.CourseRepositoryHibernate;
import progettoelle.registrazionevoti.services.ManageCoursesService;

@ManagedBean
@RequestScoped
public class ProfessorHome {
    
    private final ManageCoursesService service = new ManageCoursesService(new CourseRepositoryHibernate());
    
    @ManagedProperty(value = "#{professorSession.professor}")
    private Professor professor; 
    private DataModel<Course> courses;

    public ProfessorHome() {
    
    }
    
    @PostConstruct
    public void initialize() {
        try {
            List<Course> results = service.getCourses(professor);
            courses = new ListDataModel<>(results);
        } catch (DataLayerException ignored) { }
    }
    
    public String redirectToCourseExams(Course course){
        saveSelectedCourseToFlash();
        return "exams?faces-redirect=true";
    }
    
    public String redirectToCourseEnrolledStudents(Course course){
        saveSelectedCourseToFlash();
        return "students?faces-redirect=true";
    }
    
    private void saveSelectedCourseToFlash() {
        Course selectedCourse = courses.getRowData();
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.put("course", selectedCourse);
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public DataModel<Course> getCourses() {
        return courses;
    }

    public void setCourses(DataModel<Course> courses) {
        this.courses = courses;
    }

}
