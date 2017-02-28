/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoelle.registrazionevoti.services.exams;

import java.util.List;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Enrollment;
import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.domain.ExamResultStatus;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.EnrollmentRepository;
import progettoelle.registrazionevoti.repositories.ExamRepository;
import progettoelle.registrazionevoti.repositories.ExamResultRepository;

/**
 *
 * @author 0x4d722e43
 */
public class ConcreteStudentExamsService implements BookingExamService, AcceptExamResultService, LoadResultsHistoryService {

    private final ExamResultRepository examResultRepository;
    private final EnrollmentRepository enrollmentRepository;
    private final ExamRepository examRepository;

    public ConcreteStudentExamsService(ExamResultRepository examResultRepository,
            EnrollmentRepository enrollmentRepository, ExamRepository examRepository) {

        this.examResultRepository = examResultRepository;
        this.enrollmentRepository = enrollmentRepository;
        this.examRepository = examRepository;
    }

    @Override
    public void acceptExamResult(Student student, ExamResult examResult)
            throws DataLayerException {
        examResult.setStatus(ExamResultStatus.ACCEPTED);
        examResultRepository.updateExamResult(examResult);

        Course course = examResult.getCourse();
        Enrollment enrollment = enrollmentRepository.findEnrollmentByStudentAndCourse(student, course);
        enrollment.complete(examResult.getGrade());
        enrollmentRepository.updateEnrollment(enrollment);
    }

    @Override
    public void acknowledgeFailedExam(Student student, ExamResult examResult)
            throws DataLayerException {
        examResult.setStatus(ExamResultStatus.FAILED);
        examResultRepository.updateExamResult(examResult);
    }

    @Override
    public List<ExamResult> getExamsResults(Student student)
            throws DataLayerException {
        return examResultRepository.findStudentResults(student);
    }

    @Override
    public void rejectExamResult(Student student, ExamResult examResult)
            throws DataLayerException {
        examResult.setStatus(ExamResultStatus.REJECTED);
        examResultRepository.updateExamResult(examResult);
    }

    @Override
    public List<ExamResult> getExamResultHistory(Student student)
            throws DataLayerException {
        return examResultRepository.findStudentResultsHistory(student);
    }

    @Override
    public void bookExam(Student student, Exam exam)
            throws DataLayerException {
        ExamResult examResult = new ExamResult(student, exam);
        examResultRepository.createExamResult(examResult);
    }

    @Override
    public List<Exam> getBookableExams(Student student)
            throws DataLayerException {
        return examRepository.findAvailableExamsForStudent(student);
    }

}
