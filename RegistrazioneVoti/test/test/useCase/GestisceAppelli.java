/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.useCase;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import modellovoti2.Course;
import modellovoti2.CourseTest;
import modellovoti2.CourseTestFactory;
import modellovoti2.Student;
import modellovoti2.Teacher;
import modellovoti2.University;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gianluca
 */
public class GestisceAppelli {
    University uni;
    SimpleDateFormat sdf;
    ArrayList<Student> ss;
    CourseTest ct;
    
    public GestisceAppelli() {
        sdf = new SimpleDateFormat("DD-MM-YY kk:mm");
        XStream xs = new XStream();
        uni = (University)xs.fromXML(new File("D://uni.xml"));

    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void Gestisce (){
        String cf = "CPBGVN91M08D20N";
        CourseTestFactory ctf = uni.getTestFact();
        Teacher t = uni.getTeacherByCF(cf);
        Course c = t.getCourses().get(0);    
        
        try {
            ctf.newOne();
            ctf.setParameter("Course", c);
            ctf.setParameter("room", "EF1");
            ctf.setParameter("start_date", sdf.parse("5-10-16 09:00"));
            ctf.setParameter("end_date",sdf.parse("05-10-16 11:30"));
            ct = ctf.save();
            
        } catch (Exception ex) {
            assertTrue(false);
            Logger.getLogger(GestisceAppelli.class.getName()).log(Level.SEVERE, null, ex);
        }
        //join Test
        ss = new ArrayList<>(uni.getFacolties().get(0).getStudents().subList(0, 21));
        for(Student s:ss){
            for(CourseTest ct:s.getAvailableTests()){
                ct.join(s);
            }
        }
        for(Student s:ss){
            assert(ct.getJoined().contains(s));
        }
        //rating
        //gli studenti hanno svolto l'esame
        //il prof li ha corretti
        HashMap<Student,Integer> rs = new HashMap<>();
        for(Student s:ct.getJoined()){
            Integer vote = ThreadLocalRandom.current().nextInt(3, 31);
            rs.put(s, vote);
            ct.assignRate(s, vote);
        }
        for(Student s:ct.getJoined()){
            assertEquals(rs.get(s), ct.getRate(s).getValue());
        }
        //GLI STUDENTI VEDONO IL VOTO
        //E lo ACCETTANO/RIFIUTANO
        assertTrue("Test valutated", ct.isValutated());
        int i=0;
        for(i=0;i<ss.size();i++){
            assertNotNull(ct.getRate(ss.get(i)));
            if(i%2==0) ct.getRate(ss.get(i)).accept();
            if(i%2==1) ct.getRate(ss.get(i)).refuse();
        }
        for(i=0;i<ss.size();i++){
            if(i%2==0) assertEquals(new Integer(1),ct.getRate(ss.get(i)).getStatus());
            if(i%2==1) assertEquals(new Integer(2),ct.getRate(ss.get(i)).getStatus());
        }
    }
}
