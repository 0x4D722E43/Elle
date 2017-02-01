package utils.repositories4testPurpose;

import java.util.ArrayList;
import java.util.List;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Enrollment;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.EnrollmentRepository;

public class EnrollmentRepositoryTest implements EnrollmentRepository {

    private TestDataBase db;

    public EnrollmentRepositoryTest(TestDataBase db) {
        this.db = db;
    }

    @Override
    public void createEnrollment(Enrollment enrollment) throws DataLayerException {
        enrollment.setId(getNewId());
        db.getEnrolling().add(enrollment);
    }

    @Override
    public Enrollment findEnrollmentByStudentAndCourse(Student student, Course couser) throws DataLayerException {
        for (Enrollment e : findEnrollmentByStudent(student)) {
            if (e.getCourse().equals(couser)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public List<Enrollment> findEnrollmentByStudent(Student student) throws DataLayerException {
        List<Enrollment> out = new ArrayList<>();
        for (Enrollment e : db.getEnrolling()) {
            if (e.getStudent().equals(student)) {
                out.add(e);
            }
        }
        return out;
    }

    @Override
    public List<Student> findStudentsEnrolledOnCourse(Course course) throws DataLayerException {
        List<Student> out = new ArrayList<>();
        for (Enrollment e : db.getEnrolling()) {
            if (e.getCourse().equals(course)) {
                out.add(e.getStudent());
            }
        }
        return out;
    }

    @Override
    public void updateEnrollment(Enrollment enrollment) throws DataLayerException {
        int index = db.getEnrolling().indexOf(enrollment);
        if(index==-1) throw new DataLayerException("Enrollment not present");
        db.getEnrolling().get(index).complete(enrollment.getGrade());
    }

    private Long getNewId() {
        long max = 0;
        for (Enrollment e : db.getEnrolling()) {
            if (e.getId() >= max) {
                max = e.getId();
            }
        }
        return max;
    }

}
