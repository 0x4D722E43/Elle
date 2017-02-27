/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoelle.registrazionevoti.services.registration;

import java.util.List;
import progettoelle.registrazionevoti.domain.DegreeCourse;
import progettoelle.registrazionevoti.mail.MailException;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ValidationException;

/**
 *
 * @author jan
 */
public interface RegisterStudentService {

    List<DegreeCourse> getPossibleDegreeCourses() throws DataLayerException;

    void registerStudent(String email, String name, String surname, String matriculationNumber, DegreeCourse degreeCourse) throws ValidationException, DataLayerException, MailException;
    
}
