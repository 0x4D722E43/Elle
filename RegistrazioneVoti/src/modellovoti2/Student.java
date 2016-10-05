/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modellovoti2;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Gianluca
 */
public class Student extends Person{
    Integer year;
    Archive archive;
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
    
    /**
     *
     * @return the study plan of current year of study
     * @throws Exception
     */
    public AnnualPlan getAnnualPlan() throws Exception {
        return studyCourse.getAnnualPlan(year);
    }

    /**
     *
     * @return the student's study course
     */
    public StudyCourse getStudyCourse() {
        return studyCourse;
    }


    @Override
    public boolean equals(Object obj) {
        return ((Student)obj).getMat().equals(this.mat);
    }

    void setArchive(Archive archive) {
        this.archive = archive;
    }
  
    


 
}
