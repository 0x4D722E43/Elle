/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modellovoti2;

import java.util.ArrayList;
import java.util.HashMap;
import modellovoti2.CourseTest.Rating;

/**
 *
 * @author Gianluca
 */
public class Archive {
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private ArrayList<Faculty> faculties;
    private ArrayList<StudyCourse> studyCourses;
    private ArrayList<AnnualPlan> studyPlans;
    private ArrayList<Course> courses;
    private ArrayList<CourseTest> tests;
    //agg di corso
    private HashMap<Course,ArrayList<Student>>  studentsInCourse;
    private HashMap<Course,ArrayList<Teacher>> teachersInCourse;    
    private HashMap<Course, ArrayList<CourseTest>> testsInCourse;
    //AGG di corso di studi
    private HashMap<StudyCourse,ArrayList<Student>> studentsInStudyCourse;    
    private HashMap<StudyCourse,ArrayList<AnnualPlan>> annulPlanInStudyCourse;
    
    //agg di test
    private HashMap<CourseTest,HashMap<Student,Rating>> ratingInCourseTest;
    //agg di facoltà
    private HashMap<Faculty,ArrayList<StudyCourse>> studyCourseInFaculty;
    //agg di piano annuale
    private HashMap<AnnualPlan,ArrayList<Course>> courseInAnnualPlan;
    

    Archive(){
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.faculties = new ArrayList<>();
        this.studyCourses = new ArrayList<>();
        this.studyPlans = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.tests = new ArrayList<>();
        
        
        this.studentsInCourse = new HashMap<>();
        this.teachersInCourse = new HashMap<>();
        this.studentsInStudyCourse = new HashMap<>();
        this.ratingInCourseTest = new HashMap<>();
        this.annulPlanInStudyCourse = new HashMap<>();
        this.studyCourseInFaculty = new HashMap<>();
        this.testsInCourse = new HashMap<>();
        this.courseInAnnualPlan = new HashMap<>();
    }
    
    
    //USER
    Student getStudentByCF(String cf){
        for(Student s:students){
            if(s.getCF().equals(cf)) return s;
        }
        return null;
    }
    Teacher getTeacherByCF(String cf){
        for(Teacher t:teachers){
            if(t.getCF().equals(cf)) return t;
        }
        return null;
    }
    ///Factory's method
    void add(Student s){
        students.add(s);
    }
    void add(Teacher t){
        teachers.add(t);
    }
    void add(Faculty f){
        faculties.add(f);
    }

    void add(Course e) {
        courses.add(e);
        studentsInCourse.put(e, new ArrayList<Student>());
        teachersInCourse.put(e,new ArrayList<Teacher>());
        testsInCourse.put(e, new ArrayList<CourseTest>());
    }
    void add(StudyCourse sc){
        studyCourses.add(sc);
        studentsInStudyCourse.put(sc,new ArrayList<Student>());
        annulPlanInStudyCourse.put(sc,new ArrayList<AnnualPlan>());
    }
    void add(AnnualPlan sp){
        studyPlans.add(sp);
    }
    void add(CourseTest ct){
        tests.add(ct);
    }
    void remove(CourseTest ct){
        tests.remove(ct);
    }
    void remove(AnnualPlan sp){
        studyPlans.remove(sp);
    }
    void remove(StudyCourse sc){
        studyCourses.remove(sc);
    }
    void remove(Course c) {
        courses.remove(c);
    }
    
    void remove(Faculty f){
        faculties.remove(f);
    }
    void remove(Student s){
        students.remove(s);
    }
    void remove(Teacher t){
        teachers.remove(t);
    }

    ArrayList<Faculty> getFacolties() {
        return faculties;
    }

    ArrayList<Student> getStudents() {
        return students;
    }

    ArrayList<Teacher> getTeachers() {
       return teachers;
    }
    ArrayList<Student> getStudents(Faculty f){
        ArrayList<Student> ss = new ArrayList<>();
        for(StudyCourse sc:studyCourseInFaculty.get(f)){
            ss.addAll(studentsInStudyCourse.get(sc));
        }
        return ss;
    }
    void addToFaculty(StudyCourse sc,Faculty f) {
        studyCourseInFaculty.get(f).add(sc);
    }

    void joinToStudyCourse(Student s,StudyCourse sc) {
        studentsInStudyCourse.get(sc).add(s);
    }

    void unjoinToStudyCourse(Student s,StudyCourse sc) {
       studentsInStudyCourse.get(sc).add(s);
    }

    void putInStudyCourse(AnnualPlan ap, Integer year,StudyCourse sc) {
        annulPlanInStudyCourse.get(sc).add(year, ap);
    }

    ArrayList<Student> getStudents(StudyCourse sc) {
        return studentsInStudyCourse.get(sc);
    }

    AnnualPlan getAnnualPlan(StudyCourse sc, Integer year) {
        return annulPlanInStudyCourse.get(sc).get(year);
    }

    void addToAnnualPlan(Course course, AnnualPlan ap) {
        courseInAnnualPlan.get(ap).add(course);
    }

    void rmFromAnnualCourse(Course course, AnnualPlan ap) {
        courseInAnnualPlan.get(ap).remove(course);
    }

    ArrayList<Course> getCourse(AnnualPlan ap) {
        return courseInAnnualPlan.get(ap);
    }
    ArrayList<Course> getCourse(Teacher t) {
        ArrayList<Course> cs = new ArrayList<>();
        for(Course c:teachersInCourse.keySet())   if(teachersInCourse.get(c).contains(t)) cs.add(c);
        return cs;
    }
    StudyCourse getStudyCourse(AnnualPlan ap) {
       for(StudyCourse sc:annulPlanInStudyCourse.keySet()) if(annulPlanInStudyCourse.get(sc).contains(ap)) return sc;
       return null;
    }

    void rmFromFaculty(StudyCourse sc, Faculty f) {
        studyCourseInFaculty.get(f).remove(sc);
    }

    ArrayList<Teacher> getTeachers(Faculty f) {
        ArrayList<Teacher> ts = new ArrayList<>();
        for(Course c:this.getCourse(f)) ts.addAll(teachersInCourse.get(c));
        return ts;
    }

    ArrayList<Course> getCourse(Faculty f) {
        ArrayList<Course> cs = new ArrayList<>();
        for(StudyCourse sc:studyCourseInFaculty.get(f)){
            for(AnnualPlan ap:annulPlanInStudyCourse.get(sc)){
                cs.addAll(courseInAnnualPlan.get(ap));
            }
        }
        return cs;
    }

    void addTeacher(Teacher t, Course c) {
        teachersInCourse.get(c).add(t);
    }

    void rmTeacher(Teacher t, Course c) {
        teachersInCourse.get(c).remove(t);
    }

    void addTest(CourseTest ct, Course c) {
        testsInCourse.get(c).add(ct);
    }

    void rmTest(CourseTest ct, Course c) {
        testsInCourse.get(c).remove(ct);
    }

    ArrayList<CourseTest> getTests(Course c) {
        return testsInCourse.get(c);
    }


    ArrayList<Teacher> getTeachers(Course c) {
        return teachersInCourse.get(c);
    }

    Integer getNewStudentID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Integer getNewCourseID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void joinToTest(Student stu, CourseTest aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void unjoinFromTest(Student stu, CourseTest aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void assignRate(CourseTest.Rating rate, Student stu, CourseTest aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean isValutated(CourseTest aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    CourseTest.Rating getRates(CourseTest aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Course getCourse(CourseTest aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void addToCourse(CourseTest product, Course course) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Integer getNewTestID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Integer getNewAnnualPlanID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Faculty getFaculty(StudyCourse aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Integer getNewStudyCourseID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    
    
    
    
    

}
