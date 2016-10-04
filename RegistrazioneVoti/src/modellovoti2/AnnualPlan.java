/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modellovoti2;

import java.util.ArrayList;

/**
 *
 * @author Gianluca
 */
public class AnnualPlan {
    private String name;//Ex: Ing. Info. triennale - standard ; .... - personalizata 123 
                // Decorator
    private Archive archive;
    private Integer ID;
    public AnnualPlan(String name){
        this.name = name;      
    }
    void setName(String name) {
        this.name = name;
    }
    void setID(Integer id){
        this.ID = id;
    }
    void setArchive(Archive a){
        this.archive = a;
    }
    
    public void addCourse(Course course){
        this.archive.addToAnnualPlan(course,this);
    }
    public void rmCourse(Course course){
        this.archive.rmFromAnnualCourse(course,this);
    }
    
    public ArrayList<Course> getCourses() {
        return archive.getCourse(this);
    }
    public String getName() {
        return name;
    }
    public Integer getID(){
        return this.ID;
    }

    public StudyCourse getStudyCourse() {
        return archive.getStudyCourse(this);
    }
    
}
