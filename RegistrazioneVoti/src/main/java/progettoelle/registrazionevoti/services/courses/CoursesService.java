/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoelle.registrazionevoti.services.courses;

import java.util.List;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.DegreeCourse;
import progettoelle.registrazionevoti.domain.Enrollment;
import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ValidationException;

/**
 *
 * @author jan
 */
public interface CoursesService extends LoadEnrolledStudentsService {

    /**
     * Permette la creazione di un esame, rilascia una ValidationException se
     * esiste già un corso con lo stesso nome
     *
     * @param name
     * @param credits
     * @param professor
     * @param degreeCourse
     * @throws ValidationException
     * @throws DataLayerException
     */
    public void createCourse(String name, int credits, Professor professor, DegreeCourse degreeCourse) throws ValidationException, DataLayerException;

    public List<DegreeCourse> getPossibleDegreeCourses() throws DataLayerException;

    
    public List<Course> getCourses(Professor professor) throws DataLayerException ;
}
