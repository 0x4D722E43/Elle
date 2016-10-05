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
public class Faculty {   
    private String name;
    private Archive archive;
    private Integer ID;
    
    
    Faculty(String name){
        this.name = name;
        
    }
    void setID(Integer ID) {
        this.ID = ID;
    }
    void setArchive(Archive a){
        this.archive = a;
    }
    
    public void add(StudyCourse sc){
        archive.addToFaculty(sc,this);
    }
    public void remove(StudyCourse sc){
        archive.rmFromFaculty(sc,this);
    }
    public ArrayList<Student> getStudents() {
        return archive.getStudents(this);
    }

    public String getName() {
        return name;
    }


    public Integer getID() {
        return ID;
    }

    public ArrayList<Teacher> getTeachers() {
        return archive.getTeachers(this);
    }



    public ArrayList<Course> getCourses() {
        return archive.getCourse(this);
    }

    @Override
    public String toString() {
        return name ;
    }

    
}
