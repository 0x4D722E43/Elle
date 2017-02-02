package utils.repositories4testPurpose;

import java.util.ArrayList;
import java.util.List;
import progettoelle.registrazionevoti.domain.Course;

import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.domain.ExamResultStatus;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.ExamResultRepository;

public class ExamResultRepositoryTest implements ExamResultRepository {

    private TestDataBase db;

    public ExamResultRepositoryTest(TestDataBase db) {
        this.db = db;
    }

    @Override
    public void createExamResult(ExamResult examResult) throws DataLayerException {
        examResult.setId(getNewResultId());
        db.getExamResults().add(examResult);
    }

    @Override
    public List<ExamResult> findExamResultByExam(Exam exam) throws DataLayerException {
        List<ExamResult> out = new ArrayList<>();
        for (ExamResult er : db.getExamResults()) {
            if (er.getExam().equals(exam)) {
                out.add(er);
            }
        }
        return out;
    }

    @Override
    public List<ExamResult> findStudentBookings(Student student) throws DataLayerException {
        List<ExamResult> out = new ArrayList<>();
        for (ExamResult er : db.getExamResults()) {
            if (er.getStudent().equals(student) & er.getStatus().equals(ExamResultStatus.BOOKED)) {
                out.add(er);
            }
        }
        return out;
    }

    @Override
    public List<ExamResult> findStudentResults(Student student) throws DataLayerException {
        List<ExamResult> out = new ArrayList<>();
        for (ExamResult er : db.getExamResults()) {
            if (er.getStudent().equals(student)
                    & !er.getStatus().equals(ExamResultStatus.BOOKED)
                    //////////////////////////////////////////////////////////////////////////NON LO SO DA VEDERE A MENTE LUCIDA
                    & !er.getExam().isBookingOpen()) {
                out.add(er);
            }
        }
        return out;
    }

    @Override
    public List<ExamResult> findStudentResultsHistory(Student student) throws DataLayerException {
        List<ExamResult> out = new ArrayList<>();
        for (ExamResult er : db.getExamResults()) {
            if (er.getStudent().equals(student)) {
                out.add(er);
            }
        }
        return out;
    }

    @Override
    public void updateExamResult(ExamResult examResult) throws DataLayerException {
        int index = db.getExamResults().indexOf(examResult);
        if (index == -1) {
            throw new DataLayerException("Risultato non presente");
        }
        db.getExamResults().get(index).setGrade(examResult.getGrade());
        db.getExamResults().get(index).setStatus(examResult.getStatus());
    }

    @Override
    public void deleteExamResult(ExamResult examResult) throws DataLayerException {
        int index = db.getExamResults().indexOf(examResult);
        if (index == -1) {
            throw new DataLayerException("Risultato non presente");
        }
        db.getExamResults().remove(index);
    }

    private Long getNewResultId() {
        long max = 0;
        for (ExamResult er : db.getExamResults()) {
            if (er.getId() >= max) {
                max = er.getId();
            }
        }
        return max + 1;
    }

    @Override
    public void deleteAllBookingsForCourse(Student student, Course course) throws DataLayerException {
    }

}
