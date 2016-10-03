package modelloVoti2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Gianluca
 */
public class Teacher extends Person {
    private Archive archive;
    private University uni;
    Teacher(String name, String surname, String CF, Date birth, Date subscription) {
        super(name, surname, CF, birth, subscription);
    }
    void setArchive(Archive a){
        this.archive = a;
    }    

    public ArrayList<Course> getCourses() {
        return archive.getCourse(this);
    }


    
    
    
}
