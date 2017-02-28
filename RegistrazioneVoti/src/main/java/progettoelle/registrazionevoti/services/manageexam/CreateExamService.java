/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoelle.registrazionevoti.services.manageexam;

import java.util.Calendar;
import java.util.List;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.repositories.DataLayerException;

/**
 *
 * @author jan
 */
public interface CreateExamService {

    void createExam(Course course, Calendar date, String room, String description) throws DataLayerException;

    /**
     *
     * @param professor
     * @return I corsi di cui il professore è responsabile
     * @throws DataLayerException
     */
    List<Course> getPossibleCourses(Professor professor) throws DataLayerException;
    
}
