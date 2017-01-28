package progettoelle.registrazionevoti.domain;

public class Course extends BaseEntity {
    
    private String name;
    private Professor professor;
    private DegreeCourse degreeCourse;
    private Integer credits;
    
    public Course() {
        
    }

    public Course(String name, Integer credits, Professor professor, DegreeCourse degreeCourse) {
        this.name = name;
        this.credits = credits;
        this.professor = professor;
        this.degreeCourse = degreeCourse;
    }

    public String getName() {
        return name;
    }

    public Professor getProfessor() {
        return professor;
    }

    public DegreeCourse getDegreeCourse() {
        return degreeCourse;
    }

    public Integer getCredits() {
        return credits;
    }

    @Override
    public String toString() {
        return "Course{" + "name=" + name + '}';
    }
    
}
