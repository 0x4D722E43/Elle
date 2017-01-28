package progettoelle.registrazionevoti.services;

import java.util.List;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.exam.ExamRepository;

public final class ManageExamsService {

    private final ExamRepository examRepository;

    public ManageExamsService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }
    
    public List<Exam> getExams(Course course) throws DataLayerException {
        return examRepository.findExamByCourse(course);
    }

    public void openExamBookings(Exam exam) throws DataLayerException {
        exam.open();
        examRepository.updateExam(exam);
    }

    public void closeExamBookings(Exam exam) throws DataLayerException {
        exam.close();
        examRepository.updateExam(exam);
    }
    
}
