package progettoelle.registrazionevoti.repositories.enrollment;

import java.util.List;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Enrollment;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;

public interface EnrollmentRepository {
    
    void createEnrollment(Enrollment enrollment) throws DataLayerException;
    
    Enrollment findEnrollmentByStudentAndCourse(Student student, Course couser) throws DataLayerException;
    
    List<Enrollment> findEnrollmentByStudent(Student student) throws DataLayerException;
    
    List<Student> findStudentsEnrolledOnCourse(Course course) throws DataLayerException;
    
    void updateEnrollment(Enrollment enrollment) throws DataLayerException;

}
