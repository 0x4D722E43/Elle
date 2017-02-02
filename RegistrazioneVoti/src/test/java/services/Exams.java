/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;

import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.domain.Student;

import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.UserRepository;
import progettoelle.registrazionevoti.services.manageexam.BookExamService;
import progettoelle.registrazionevoti.services.manageexam.CreateExamService;

import utils.repositories4testPurpose.CourseRepositoryTest;
import utils.repositories4testPurpose.ExamRepositoryTest;
import utils.repositories4testPurpose.ExamResultRepositoryTest;
import utils.repositories4testPurpose.TestDataBase;
import utils.repositories4testPurpose.UserRepositoryTest;

import static org.junit.Assert.*;
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.services.manageexam.GradeExamService;

/**
 *
 * @author mrc
 */
public class Exams {

    private TestDataBase db;
    private CourseRepositoryTest courseRepository;
    private UserRepositoryTest userRepository;
    private ExamRepositoryTest examRepository;
    private ExamResultRepositoryTest examResultRepository;

    @Before
    public void setUp() {
        db = new TestDataBase();
        db.init();
        courseRepository = new CourseRepositoryTest(db);
        examRepository = new ExamRepositoryTest(db);
        userRepository = new UserRepositoryTest(db);
        examResultRepository = new ExamResultRepositoryTest(db);
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
            Logger.getLogger(Exams.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //@Test 
    public void bookExam(){
        try {
            BookExamService bes = new BookExamService(examRepository,
                    examResultRepository);
            Student totti = (Student) userRepository.findUserById(6);
            List<Exam> exams = bes.getBookableExams(totti);
            assertNotNull(exams);
            assertEquals(1, exams.size());
            bes.bookExam(totti, exams.get(0));
            exams = bes.getBookableExams(totti);
            assertEquals(0, exams.get(0));
            
        } catch (DataLayerException ex) {
            Logger.getLogger(Exams.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //@Test
    public void gradeExam(){
        try{
            GradeExamService ges = new GradeExamService(examResultRepository);
            Student delPiero = (Student) userRepository.findUserById(5);            
            List<ExamResult> ers = ges.getExamResults(
                    examRepository.findAvailableExamsForStudent(delPiero).get(0));
            assertEquals(1, ers.size());
        } catch (DataLayerException ex) {
            Logger.getLogger(Exams.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
