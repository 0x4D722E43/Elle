/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoelle.registrazionevoti.services.courses;

import java.util.List;
import progettoelle.registrazionevoti.domain.Enrollment;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;

/**
 *
 * @author jan
 */
public interface LoadStudentEnrollmentsService {

    /**
     *
     * @param student
     * @return Le iscrizioni dello studente
     * @throws DataLayerException
     */
    List<Enrollment> getEnrollments(Student student) throws DataLayerException;
    
}
