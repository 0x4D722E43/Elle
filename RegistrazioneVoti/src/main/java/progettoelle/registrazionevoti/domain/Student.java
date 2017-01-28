package progettoelle.registrazionevoti.domain;

public class Student extends RegisteredUser {
    
    private String matriculationNumber;
    private DegreeCourse degreeCourse;
    
    public Student() {
        
    }

    public Student(String email, String name, String surname, String matriculationNumber, DegreeCourse degreeCourse) {
        super(email, name, surname);
        this.matriculationNumber = matriculationNumber;
        this.degreeCourse = degreeCourse;
    }

    public DegreeCourse getDegreeCourse() {
        return degreeCourse;
    }
    
}
