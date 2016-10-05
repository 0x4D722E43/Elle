/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modellovoti2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Gianluca
 */
public class StudyCourse {
    private String name;
    private Integer years;
    private Archive archive;
    private Integer ID;

    /**
     * StudyCourse
     * @param name
     * @param years
     */
    public StudyCourse(String name, Integer years) {
        this.name = name;
        this.years = years;
    }
    void setArchive(Archive a){
        this.archive = a;
    }
    void setFaculty(Faculty f){
        this.archive.addToFaculty(this,f);
    }
    void setID(Integer id){
        this.ID = id;
    }
    Faculty getFaculty() {
        return archive.getFaculty(this);
    }

    /**
     *
     * @return id
     */
    public Integer getID(){
        return this.ID;
    }

    /**
     *
     * @return name of studyCourse
     */
    public String getName(){
        return this.name;
    }

    /**
     *
     * @param student
     */
    public void join(Student s){
        archive.joinToStudyCourse(s,this);
    }

    /**
     *
     * @param student 
     */
    public void unjoin(Student s){
        archive.unjoinToStudyCourse(s,this);
    }

    /**
     *
     * @param year year of annual plan
     * @param ap annual plan
     */
    public void put(Integer year, AnnualPlan ap) {
        archive.putInStudyCourse(ap,year-1,this);
    }
    
    /**
     *
     * @return the students of study course
     */
    public ArrayList<Student> getStudents() {
        return archive.getStudents(this);
    }
    
    /**
     *
     * @param year
     * @return the relative annual plan
     */
    public AnnualPlan getAnnualPlan(Integer year){
        return archive.getAnnualPlan(this,year);
    }

    /**
     *
     * @return years duration of the studycourse
     */
    public int getYears() {
        return years;
    }
    
}
