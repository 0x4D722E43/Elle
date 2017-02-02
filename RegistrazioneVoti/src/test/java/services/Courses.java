/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.DegreeCourse;
import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ValidationException;
import progettoelle.registrazionevoti.services.managecourse.CreateCourseService;
import utils.repositories4testPurpose.CourseRepositoryTest;
import utils.repositories4testPurpose.DegreeCourseRepositoryTest;
import utils.repositories4testPurpose.EnrollmentRepositoryTest;
import utils.repositories4testPurpose.TestDataBase;
import utils.repositories4testPurpose.UserRepositoryTest;

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
    
    @After
    public void tearDown() {
    }
    @Test 
    public void createCourse(){
        try {
            CreateCourseService ccs = new CreateCourseService(degreeCourseRepository,
                    courseRepository);
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
}
