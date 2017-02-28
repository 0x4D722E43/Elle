/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import java.util.Random;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.hamcrest.Description;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.DegreeCourse;
import progettoelle.registrazionevoti.domain.Enrollment;
import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.domain.Student;

import progettoelle.registrazionevoti.repositories.DataLayerException;

import progettoelle.registrazionevoti.services.ValidationException;

import progettoelle.registrazionevoti.services.managecourse.ConcreteCoursesService;
import progettoelle.registrazionevoti.services.managecourse.ConcreteEnrollmentsService;
import utils.MailServiceTest;

import utils.repositories4testPurpose.CourseRepositoryTest;
import utils.repositories4testPurpose.DegreeCourseRepositoryTest;
import utils.repositories4testPurpose.EnrollmentRepositoryTest;
import utils.repositories4testPurpose.TestDataBase;
import utils.repositories4testPurpose.UserRepositoryTest;
import progettoelle.registrazionevoti.services.managecourse.LoadStudentEnrollmentsService;
import progettoelle.registrazionevoti.services.managecourse.LoadEnrolledStudentsService;

/**
 *
 * @author mrc
 */
public class Courses {

    private TestDataBase db;
    private EnrollmentRepositoryTest enrollRepository;
    private UserRepositoryTest userRepositoryTest;
    private CourseRepositoryTest courseRepository;
    private DegreeCourseRepositoryTest degreeCourseRepository;

    @Before
    public void setUp() {
        db = new TestDataBase();
        db.init();
        enrollRepository = new EnrollmentRepositoryTest(db);
        courseRepository = new CourseRepositoryTest(db);
        degreeCourseRepository = new DegreeCourseRepositoryTest(db);
        userRepositoryTest = new UserRepositoryTest(db);

    }

    @Test
    public void createCourse() {
        try {
            ConcreteCoursesService ccs = new ConcreteCoursesService(degreeCourseRepository,
                    courseRepository,enrollRepository);
            int index = (new Random()).nextInt(ccs.getPossibleDegreeCourses().size());
            DegreeCourse dc = ccs.getPossibleDegreeCourses().get(index);
            Professor professor = (Professor) userRepositoryTest.findUserById(0);

            ccs.createCourse("Course test", 9, professor, dc);

            Course c = courseRepository.findCourseByName("Course test");
            assertNotNull(c);
            assertEquals(professor, c.getProfessor());
        } catch (DataLayerException ex) {
            Logger.getLogger(Courses.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ValidationException ex) {
            fail();
        }
    }

    @Test
    public void enrollOnCourse() {
        ConcreteEnrollmentsService ecs = new ConcreteEnrollmentsService(courseRepository,
                enrollRepository);
        Student student = null;
        try {
            student = (Student) userRepositoryTest.findUserByEmail("alessandro.delpiero01@universitadipavia.it");
        } catch (DataLayerException ex) {
            fail();
        }
        try {
            List<Course> cs = ecs.getCoursesOnWhichStudentCanEnroll(student);
            assertEquals(8, cs.size());
            ecs.enrollOnCourse(student, cs.get(0));
            boolean join = false;
            for (Enrollment e : enrollRepository.findEnrollmentByStudent(student)) {
                if (e.getCourse().equals(cs.get(0))) {
                    join = true;
                }
            }
            assertTrue("Not actualy enrolled", join);
            cs = ecs.getCoursesOnWhichStudentCanEnroll(student);
            assertEquals(7, cs.size());
        } catch (DataLayerException ex) {
            fail();
        }

    }

    @Test
    public void loadProfessorCourses() {
        ConcreteCoursesService lpcs = new ConcreteCoursesService(degreeCourseRepository, courseRepository, enrollRepository);
        Professor albert = null, boole = null;
        try {
            albert = (Professor) userRepositoryTest.findUserById(1);
            boole = (Professor) userRepositoryTest.findUserById(3);
        } catch (DataLayerException ex) {
            Logger.getLogger(Courses.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(albert);
        assertNotNull(boole);
        try {
            List<Course> cs = lpcs.getCourses(albert);
            assertEquals(3, cs.size());
            cs = lpcs.getCourses(boole);
            assertEquals(2, cs.size());
        } catch (DataLayerException ex) {
            Logger.getLogger(Courses.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void loadEnrollement() {
        LoadStudentEnrollmentsService lses = new ConcreteEnrollmentsService(courseRepository, enrollRepository);
        LoadEnrolledStudentsService less = new ConcreteCoursesService(degreeCourseRepository, courseRepository, enrollRepository);
        Student delPiero = null, totti = null;
        Course analisi = null;
        try {
            analisi = courseRepository.findCourseByName("Analisi I");

            delPiero = (Student) userRepositoryTest.findUserById(5);
            totti = (Student) userRepositoryTest.findUserById(6);
        } catch (DataLayerException ex) {
            Logger.getLogger(Courses.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(delPiero);
        assertNotNull(totti);
        assertNotNull(analisi);
        try {
            List<Enrollment> en_totti = lses.getEnrollments(totti),
                    en_delPiero = lses.getEnrollments(delPiero);
            assertEquals(1, en_delPiero.size());
            assertEquals(1, en_totti.size());

            List<Enrollment> ss = less.getEnrolledStudents(analisi);
            assertEquals(6, ss.size());
            ///
            final Student t=totti,dp=delPiero;
            assertThat(ss, new org.hamcrest.BaseMatcher<List<Enrollment>>() {
                @Override
                public boolean matches(Object o) {
                    List<Enrollment> list = (List<Enrollment>) o;
                    int valid = 0;
                    for(Enrollment e:list){
                        if(e.getStudent().equals(t)|
                                e.getStudent().equals(dp)){
                            valid++;
                        }
                    }
                    return valid==2;
                }

                @Override
                public void describeTo(Description d) {
                    d.appendText("One or more enrolled student are not present");
                }
            });
        } catch (DataLayerException ex) {
            Logger.getLogger(Courses.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
