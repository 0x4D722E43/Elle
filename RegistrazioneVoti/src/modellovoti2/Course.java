/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modellovoti2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Gianluca
 */
public class Course {
    Integer credits;
    Integer ID;
    String name;
    Archive archive;

    Course(String name,Integer credits) {
        this.name = name;
        this.credits = credits;
    }

    void setCredits(Integer credits) {
        this.credits = credits;
    }

    /**
     * assign a teacher to course
     * @param teacher
     */
    public void addTeacher(Teacher t){
        archive.addTeacher(t,this);
    }

    /**
     * Remove a teacher assigned to course
     * @param teacher
     */
    public void rmTeacher(Teacher t){
        archive.rmTeacher(t,this);
    }

    /**
     *
     * @param test
     */
    public void addTest(CourseTest ct){
        archive.addTest(ct,this);
    }

    /**
     *
     * @param test 
     */
    public void rmTest(CourseTest ct){
        archive.rmTest(ct,this);
    }

    /**
     *
     * @return tests list of tests assigned to course
     * @see CourseTest
     */
    public ArrayList<CourseTest> getTests() {
        return archive.getTests(this);
    }

    /**
     *
     * @return teachers list
     */
    public ArrayList<Teacher> getTeachers() {
        return archive.getTeachers(this);
    }

    /**
     *
     * @return
     */
    public Integer getCredits(){
        return credits;
    }
    public Integer getID() {
        return ID; //To change body of generated methods, choose Tools | Templates.
    }
    public String getName(){
        return name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.ID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        } 
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Course other = (Course) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return true;
    }

    void setID(Integer ID) {
        this.ID = ID;
    }

    void setArchive(Archive archive) {
        this.archive =archive;
    }


    
    
    
}
