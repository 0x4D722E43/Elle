/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modellovoti2;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gianluca
 */
public class Student extends Person{
    Integer year;
    Archive archive;
    Student(String name, String surname, String CF, Date birth, Date subscription) {
        super(name, surname, CF, birth, subscription);
        this.year=1;
    }
    
    void setStudyCourse(StudyCourse studyCourse) {
        archive.joinToStudyCourse(this, studyCourse);
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
        return getStudyCourse().getAnnualPlan(year);
    }

    /**
     *
     * @return the student's study course
     */
    public StudyCourse getStudyCourse() {
        return archive.getStudyCourse(this);
    }

    /**
     *
     * @return the joinable student's tests
     */
    public ArrayList<CourseTest> getAvailableTests() {
        ArrayList<CourseTest> tmp = new ArrayList<>();
        try {
            for(Course c:getAnnualPlan().getCourses()){
                if(c.hasAvailableTests()) tmp.addAll(c.getTests());
            }
        } catch (Exception ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tmp;
    }

    @Override
    public boolean equals(Object obj) {
        return ((Student)obj).getMat().equals(this.mat);
    }

    void setArchive(Archive archive) {
        this.archive = archive;
    }


  
    


 
}
