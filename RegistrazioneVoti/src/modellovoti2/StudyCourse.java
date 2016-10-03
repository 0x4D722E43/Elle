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
    public Integer getID(){
        return this.ID;
    }
    public String getName(){
        return this.name;
    }
    public void join(Student s){
        archive.joinToStudyCourse(s,this);
    }
    public void unjoin(Student s){
        archive.unjoinToStudyCourse(s,this);
    }


    public void put(Integer year, AnnualPlan sp) {
        archive.putInStudyCourse(sp,year,this);
    }
    

    public ArrayList<Student> getStudents() {
        return archive.getStudents(this);
    }
    
    public AnnualPlan getAnnualPlan(Integer year){
        return archive.getAnnualPlan(this,year);
    }

    public int getYears() {
        return years;
    }
    
}
