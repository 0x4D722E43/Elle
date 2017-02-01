/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.UserRepository;
import progettoelle.registrazionevoti.services.manageexam.CreateExamService;
import utils.repositories4testPurpose.CourseRepositoryTest;
import utils.repositories4testPurpose.ExamRepositoryTest;
import utils.repositories4testPurpose.TestDataBase;
import utils.repositories4testPurpose.UserRepositoryTest;

/**
 *
 * @author mrc
 */
public class Exam {

    private TestDataBase db;
    private CourseRepositoryTest courseRepository;
    private UserRepositoryTest userRepository;
    private ExamRepositoryTest examRepository;

    @Before
    public void setUp() {
        db = new TestDataBase();
        db.init();
        courseRepository = new CourseRepositoryTest(db);
        examRepository = new ExamRepositoryTest(db);
        userRepository = new UserRepositoryTest(db);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void createExam() {
        CreateExamService ces = new CreateExamService(courseRepository, examRepository);
        try {
            Professor prof = (Professor) userRepository.findUserById(1);
            Course c = courseRepository.findCourseByProfessor(prof).get(0);
            Calendar date = Calendar.getInstance();
            date.set(2016, 0, 16, 9, 0);
            ces.createExam(c, date, "EF1", "qualcosa...");
        } catch (DataLayerException ex) {
            fail();
            Logger.getLogger(Exam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
