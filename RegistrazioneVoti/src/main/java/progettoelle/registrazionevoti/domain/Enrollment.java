package progettoelle.registrazionevoti.domain;

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
    
    public void setCompleted(int grade) {
        this.grade = grade;
        completed = true;
    }

    @Override
    public String toString() {
        return student + " " + course;
    }
    
    
}
