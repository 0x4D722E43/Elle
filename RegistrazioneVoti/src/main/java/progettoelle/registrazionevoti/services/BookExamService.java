package progettoelle.registrazionevoti.services;

import java.util.List;
import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.exam.ExamRepository;
import progettoelle.registrazionevoti.repositories.examresult.ExamResultRepository;

public final class BookExamService {
    
    private final ExamRepository examRepository;
    private final ExamResultRepository examResultRepository;

    public BookExamService(ExamRepository examRepository, ExamResultRepository examResultRepository) {
        this.examRepository = examRepository;
        this.examResultRepository = examResultRepository;
    }
    
    public List<Exam> getBookableExams(Student student) throws DataLayerException {
        return examRepository.findAvailableExamsForStudent(student);
    }

    public void bookExam(Student student, Exam exam) throws DataLayerException {
        ExamResult examResult = new ExamResult(student, exam);
        examResultRepository.createExamResult(examResult);
    }
    
}
