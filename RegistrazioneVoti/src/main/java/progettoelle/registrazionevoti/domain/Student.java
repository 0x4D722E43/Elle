package progettoelle.registrazionevoti.domain;

/**
 * Caratterizato da matricola e corso di laurea
 * @author mrc
 */
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

    public String getMatriculationNumber() {
        return matriculationNumber;
    }
    
    public DegreeCourse getDegreeCourse() {
        return degreeCourse;
    }
    
}
