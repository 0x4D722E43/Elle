/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modellovoti2.AnnualPlan;
import modellovoti2.AnnualPlanFactory;
import modellovoti2.Course;
import modellovoti2.CourseFactory;
import modellovoti2.Faculty;
import modellovoti2.FacultyFactory;
import modellovoti2.StudentFactory;
import modellovoti2.StudyCourse;
import modellovoti2.StudyCourseFactory;
import modellovoti2.TeacherFactory;
import modellovoti2.University;

/**
 *
 * @author Gianluca
 */
public class Test03 {

    University uni;
    Faculty ing;
    ArrayList<Course> primo, secondo, terzo;
    ArrayList<AnnualPlan> pianiAnnuali;
    StudyCourse ingEleInf;

    public static void main(String[] args) {
        new Test03();
    }

    Test03() {
        uni = new University();
        primo = new ArrayList<>();
        secondo = new ArrayList<>();
        terzo = new ArrayList<>();
        pianiAnnuali = new ArrayList<>();
        initFaculty();
        initCourses();
        initAnnualPlan();
        initStudyCourse();
    }

    void initFaculty() {
        try {
            FacultyFactory ff = uni.getFacultyFact();
            ff.setParameter("name", "Ingegneria");
            ing = ff.save();
        } catch (Exception ex) {
            Logger.getLogger(Test03.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void initStudyCourse() {
        StudyCourseFactory scf = uni.getStudyCourseFact();
        try {
            scf.setParameter("name", "ingegneria elettronica/informatica");
            scf.setParameter("years", new Integer(3));
            scf.setParameter("faculty", ing);
            ingEleInf = scf.save();
            ingEleInf.put(1, pianiAnnuali.get(0));
            ingEleInf.put(2, pianiAnnuali.get(1));
            ingEleInf.put(3, pianiAnnuali.get(2));
        } catch (Exception ex) {
            Logger.getLogger(Test03.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void initCourses() {
        CourseFactory cf = uni.getCourseFact();
        for (int i = 0; i <= 9; i++) {
            try {
                cf.newOne();
                cf.setParameter("name", "CorsoPrimo_" + i);
                cf.setParameter("credits", (i % 2 == 1) ? 6 : 9);
                primo.add(cf.save());
            } catch (Exception ex) {
                Logger.getLogger(Test03.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (int i = 0; i <= 9; i++) {
            try {
                cf.newOne();
                cf.setParameter("name", "CorsoSecondo_" + i);
                cf.setParameter("credits", (i % 2 == 1) ? 6 : 9);
                secondo.add(cf.save());
            } catch (Exception ex) {
                Logger.getLogger(Test03.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (int i = 0; i <= 9; i++) {
            try {
                cf.newOne();
                cf.setParameter("name", "CorsoTerzo_" + i);
                cf.setParameter("credits", (i % 2 == 1) ? 6 : 9);
                terzo.add(cf.save());
            } catch (Exception ex) {
                Logger.getLogger(Test03.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    void initAnnualPlan() {
        try {
            AnnualPlanFactory apf = uni.getAnnualPlanFact();
            AnnualPlan ap;

            apf.newOne();
            apf.setParameter("name", "anno uno");
            ap = apf.save();
            for (Course c : primo) {
                ap.addCourse(c);
            }
            pianiAnnuali.add(ap);

            apf.newOne();
            apf.setParameter("name", "anno due");
            ap = apf.save();
            for (Course c : secondo) {
                ap.addCourse(c);
            }
            pianiAnnuali.add(ap);

            apf.newOne();
            apf.setParameter("name", "anno tre");
            ap = apf.save();
            for (Course c : terzo) {
                ap.addCourse(c);
            }
            pianiAnnuali.add(ap);

        } catch (Exception ex) {
            Logger.getLogger(Test03.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void initStudents() {
        StudentFactory sf = uni.getStudentFact();
        SimpleDateFormat sdf = new SimpleDateFormat("DD-MM-YY");
        for (int i = 0; i < 50; i++) {
            try {
                sf.setParameter("Name", "Giovanni" + Integer.toString(i));
                sf.setParameter("Surname", "Capobianco" + Integer.toString(i));
                sf.setParameter("CF", "CPBGVN91M08D2" + Integer.toString(i) + "N");
                sf.setParameter("Birth_Date", sdf.parse("08-08-91"));
                sf.setParameter("subscription_Date", sdf.parse("01-09-16"));
                ingEleInf.join(sf.save());
            } catch (Exception ex) {
                Logger.getLogger(Test03.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    void initTeachers() {
        TeacherFactory tf = uni.getTeacherFact();
        SimpleDateFormat sdf = new SimpleDateFormat("DD-MM-YY");
        for (int i = 0; i <= 9; i++) {
            try {
                tf.setParameter("Name", "Giovanni" + Integer.toString(i));
                tf.setParameter("Surname", "danese" + Integer.toString(i));
                tf.setParameter("CF", "CPBGVN91M08D2" + Integer.toString(i) + "N");
                tf.setParameter("Birth_Date", sdf.parse("08-08-52"));
                tf.setParameter("subscription_Date", sdf.parse("01-09-93"));
                primo.get(i).addTeacher(tf.save());
            } catch (Exception ex) {
                Logger.getLogger(Test03.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (int i = 0; i <= 9; i++) {
            try {
                tf.setParameter("Name", "Sabina" + Integer.toString(i));
                tf.setParameter("Surname", "Merlo" + Integer.toString(i));
                tf.setParameter("CF", "CPBGVN91M08D2" + Integer.toString(i) + "N");
                tf.setParameter("Birth_Date", sdf.parse("08-08-52"));
                tf.setParameter("subscription_Date", sdf.parse("01-09-93"));
                primo.get(i).addTeacher(tf.save());
            } catch (Exception ex) {
                Logger.getLogger(Test03.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        for (int i = 0; i <= 9; i++) {
            try {
                tf.setParameter("Name", "Diego" + Integer.toString(i));
                tf.setParameter("Surname", "Maradona" + Integer.toString(i));
                tf.setParameter("CF", "CPBGVN91M08D2" + Integer.toString(i) + "N");
                tf.setParameter("Birth_Date", sdf.parse("08-08-52"));
                tf.setParameter("subscription_Date", sdf.parse("01-09-93"));
                primo.get(i).addTeacher(tf.save());
            } catch (Exception ex) {
                Logger.getLogger(Test03.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
