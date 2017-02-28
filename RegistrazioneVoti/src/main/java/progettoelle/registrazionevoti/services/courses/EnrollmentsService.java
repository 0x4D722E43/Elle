/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoelle.registrazionevoti.services.courses;

import java.util.List;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;

/**
 *
 * @author 0x4d722e43
 */
public interface EnrollmentsService extends LoadStudentEnrollmentsService {

    /**
     * Permette di iscrivere uno studente a un corso
     * @param student
     * @param course
     * @throws DataLayerException
     */
    public void enrollOnCourse(Student student, Course course) throws DataLayerException;

    /**
     *
     * @param student
     * @return corsi ai quali lo studente può iscriversi
     * @throws DataLayerException
     */
    public List<Course> getCoursesOnWhichStudentCanEnroll(Student student) throws DataLayerException;
        
}
