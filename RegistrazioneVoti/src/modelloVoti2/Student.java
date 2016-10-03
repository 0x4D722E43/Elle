package modelloVoti2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Gianluca
 */
public class Student extends Person{
    Integer year;
    StudyCourse studyCourse;
    ArrayList<CourseTest> tests;
    Student(String name, String surname, String CF, Date birth, Date subscription) {
        super(name, surname, CF, birth, subscription);
    }
    
    void setStudyCourse(StudyCourse studyCourse) {
        this.studyCourse = studyCourse;
    }

    void setYear(Integer year) {
        this.year = year;
    }
    
    
    
    public AnnualPlan getStudyPlan() throws Exception {
        return studyCourse.getAnnualPlan(year);
    }

    public Person getUserInfo() {
        return (Person)this;
    }
    public StudyCourse getStudyCourse() {
        return studyCourse;
    }


    @Override
    public boolean equals(Object obj) {
        return ((Person)obj).equals(this);
    }
  
    


 
}
