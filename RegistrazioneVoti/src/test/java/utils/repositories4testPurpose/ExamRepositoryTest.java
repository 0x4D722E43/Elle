package utils.repositories4testPurpose;

import java.util.ArrayList;
import java.util.List;
import progettoelle.registrazionevoti.controllers.student.EnrollOnCourse;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Enrollment;
import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.ExamRepository;

public class ExamRepositoryTest implements ExamRepository {

    private TestDataBase db;

    public ExamRepositoryTest(TestDataBase db) {
        this.db = db;
    }

    @Override
    public void createExam(Exam exam) throws DataLayerException {
        exam.setId(getNewId());
        db.getExams().add(exam);
    }

    @Override
    public List<Exam> findExamByCourse(Course course) throws DataLayerException {
        List<Exam> out = new ArrayList<>();
        for (Exam e : db.getExams()) {
            if (e.getCourse().equals(course)) {
                out.add(e);
            }
        }
        return out;
    }

    @Override
    public List<Exam> findAvailableExamsForStudent(Student student) throws DataLayerException {
        List<Exam> out = new ArrayList<>();
        ///esami di corsi a cui gli studenti sono iscritti,
        ///Ma non è stato superato
        for(Enrollment eoc:db.getEnrolling()){
            if(eoc.getStudent().equals(student)){
                if(!eoc.isCompleted()){
                   for(Exam e:findExamByCourse(eoc.getCourse())){
                       if(e.isBookingOpen()){
                           out.add(e);
                       }
                   }
                }
            }
        }
        return out;
    }

    @Override
    public void updateExam(Exam exam) throws DataLayerException {
        int index = db.getExams().indexOf(exam);
        db.getExams().remove(index);
        db.getExams().add(exam);
    }

    private Long getNewId() {
        long max=0;
        for(Exam e:db.getExams()){
            if(e.getId()>=max) max = e.getId();
        }
        return max+1;
    }

}
