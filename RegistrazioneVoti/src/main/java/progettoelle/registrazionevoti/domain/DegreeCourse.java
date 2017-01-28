package progettoelle.registrazionevoti.domain;

public class DegreeCourse extends BaseEntity {

    private String name;
    private Faculty faculty;
    
    public DegreeCourse() {
        
    }
    
    public DegreeCourse(String name, Faculty faculty) {
        this.name = name;
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return name;
    }
    
}