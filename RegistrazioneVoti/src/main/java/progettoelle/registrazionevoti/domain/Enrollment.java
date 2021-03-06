package progettoelle.registrazionevoti.domain;

/**
 *  
 * Enrollement rapresenta la relazione studente-corso
 * è caratterizata dalla valutazione conseguita
 * (null se lo studente non ha completato, positivamente, un esame del corso)
 * @author mrc
 */
public class Enrollment extends BaseEntity {
    
    private Course course;
    private Student student;
    private boolean completed;
    private Integer grade;
    
    public Enrollment() {
    
    }

    public Enrollment(Student student, Course course) {
        this.course = course;
        this.student = student;
        completed = false;
    }
    
    public void complete(int grade) {
        this.grade = grade;
        completed = true;
    }
    
    public String getPrintableGrade() {
        if (grade == null) return "";
        if (grade < 31) return String.valueOf(grade);
        else return "30L";
    }

    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }

    public boolean isCompleted() {
        return completed;
    }

    public Integer getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Enrollment { " + getId() + " }";
    }
    
}
