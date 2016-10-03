package modelloVoti2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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

    public StudyCourse getStudyCourse() {
        return archive.getStudyCourse(this);
    }
    
}
