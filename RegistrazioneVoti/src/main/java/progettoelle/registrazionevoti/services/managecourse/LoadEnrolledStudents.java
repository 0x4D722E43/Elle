/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoelle.registrazionevoti.services.managecourse;

import java.util.List;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Enrollment;
import progettoelle.registrazionevoti.repositories.DataLayerException;

/**
 *
 * @author jan
 */
public interface LoadEnrolledStudents {

    /**
     *
     * @param course
     * @return Le iscrizioni al corso
     * @throws DataLayerException
     */
    List<Enrollment> getEnrolledStudents(Course course) throws DataLayerException;
    
}
