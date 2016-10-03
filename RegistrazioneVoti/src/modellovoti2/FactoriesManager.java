/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modellovoti2;

import java.util.HashMap;

/**
 *
 * @author Gianluca
 */
public class FactoriesManager {


    public enum type{
        STUDENT,TEACHER,COURSE,TEST,STUDY_PLAN,
        STUDY_COURSE,FACULTY
    }
    private HashMap<type,AbstractFactory> factories;

    FactoriesManager(Archive a) {
        factories = new HashMap<>();
        initFactories(a);
    }
    
    private void initFactories(Archive a) {
        factories.put(type.STUDENT,new StudentFactory(a));
        factories.put(type.TEACHER,new TeacherFactory(a));
        factories.put(type.COURSE,new CourseFactory(a));
        factories.put(type.TEST,new CourseTestFactory(a));
        factories.put(type.STUDY_PLAN, new AnnualPlanFactory(a));
        factories.put(type.STUDY_COURSE, new StudyCourseFactory(a));
        factories.put(type.FACULTY,new FacultyFactory(a));
    }
    public AbstractFactory getFactory(type t){
        return factories.get(t);
    }
    
}
