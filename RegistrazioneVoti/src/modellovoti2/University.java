/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modellovoti2;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Gianluca
 */
public class University{
    private Archive archive;
    private FactoriesManager factManager;
    public University(){
        archive = new Archive();
        factManager = new FactoriesManager(archive);        
    }

    
    public void add(Faculty f){
        archive.add(f);
    }
    public void remove(Faculty f){
        archive.remove(f);
    }
    public Teacher getTeacherByCF(String cf){
        return archive.getTeacherByCF(cf);
    }
    public Student getStudentByCF(String cf){
       return archive.getStudentByCF(cf);
    }

    public ArrayList<Faculty> getFacolties() {
        return archive.getFacolties();
    }

    //FACTORIES
    
    @Deprecated
    public FactoriesManager getFactManager() {
        return factManager;
    }
    public FacultyFactory getFacultyFact(){
        return (FacultyFactory)factManager.getFactory(FactoriesManager.type.FACULTY);
    }
    public StudentFactory getStudentFact(){
        return (StudentFactory)factManager.getFactory(FactoriesManager.type.STUDENT);
    }
    public TeacherFactory getTeacherFact(){
        return (TeacherFactory)factManager.getFactory(FactoriesManager.type.TEACHER);
    }
    public CourseFactory getCourseFact(){
        return (CourseFactory)factManager.getFactory(FactoriesManager.type.COURSE);
    }
    public StudyCourseFactory getStudyCourseFact(){
        return (StudyCourseFactory)factManager.getFactory(FactoriesManager.type.STUDY_COURSE);
    }
    public AnnualPlanFactory getAnnualPlanFact(){
        return (AnnualPlanFactory)factManager.getFactory(FactoriesManager.type.STUDY_PLAN);
    }
    public CourseTestFactory getTestFact(){
        return (CourseTestFactory)factManager.getFactory(FactoriesManager.type.TEST);
    }
}
