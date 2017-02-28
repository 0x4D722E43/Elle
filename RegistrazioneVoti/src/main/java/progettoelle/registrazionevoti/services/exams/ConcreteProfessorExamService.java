/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoelle.registrazionevoti.services.exams;

import java.util.Calendar;
import java.util.List;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.CourseRepository;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.ExamRepository;
import progettoelle.registrazionevoti.repositories.ExamResultRepository;

/**
 *
 * @author 0x4d722e43
 */
public class ConcreteProfessorExamService implements CreateExamService,
        GradeExamService, ManageExamBookingsService, OpenExamBookingsService {

    private final CourseRepository courseRepository;
    private final ExamRepository examRepository;
    private final ExamResultRepository examResultRepository;

    public ConcreteProfessorExamService(CourseRepository courseRepository, ExamRepository examRepository, ExamResultRepository examResultRepository) {
        this.examResultRepository = examResultRepository;
        this.courseRepository = courseRepository;
        this.examRepository = examRepository;
    }

    //CREATE
    @Override
    public void createExam(Course course, Calendar date, String room, String description) throws DataLayerException {
        Exam exam = new Exam(course, date, room, description);
        examRepository.createExam(exam);
    }

    @Override
    public List<Course> getPossibleCourses(Professor professor) throws DataLayerException {
        return courseRepository.findCourseByProfessor(professor);
    }

    //GRADE
    @Override
    public List<ExamResult> getExamResults(Exam exam) throws DataLayerException {
        return examResultRepository.findExamResultByExam(exam);
    }

    @Override
    public void gradeExam(int mark, ExamResult examResult) throws DataLayerException {
        examResult.grade(mark);
        examResultRepository.updateExamResult(examResult);
    }

    //MANAGE
    @Override
    public void cancelExamBooking(ExamResult examResult) throws DataLayerException {
        examResultRepository.deleteExamResult(examResult);
    }

    @Override
    public List<ExamResult> getExamBookings(Student student) throws DataLayerException {
        return examResultRepository.findStudentBookings(student);
    }

    ///OPEN
    @Override
    public void closeExamBookings(Exam exam) throws DataLayerException {
        exam.closeBookings();
        examRepository.updateExam(exam);
    }

    @Override
    public List<Exam> getExams(Course course) throws DataLayerException {
        return examRepository.findExamByCourse(course);
    }

    @Override
    public void openExamBookings(Exam exam) throws DataLayerException {
        exam.openBookings();
        examRepository.updateExam(exam);
    }

}
