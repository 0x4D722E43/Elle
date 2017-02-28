/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoelle.registrazionevoti.services.manageexam;

import java.util.List;
import progettoelle.registrazionevoti.domain.Course;
import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.repositories.DataLayerException;

/**
 *
 * @author jan
 */
public interface OpenExamBookingsService {

    /**
     * Chiude la prenotazione del esame
     * @param exam
     * @throws DataLayerException
     */
    void closeExamBookings(Exam exam) throws DataLayerException;

    /**
     *
     * @param course
     * @return Esami del corso
     * @throws DataLayerException
     */
    List<Exam> getExams(Course course) throws DataLayerException;

    /**
     *  Apre le prenotazione del esame
     * @param exam
     * @throws DataLayerException
     */
    void openExamBookings(Exam exam) throws DataLayerException;
    
}
