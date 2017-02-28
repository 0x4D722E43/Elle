/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoelle.registrazionevoti.services.exams;

import java.util.List;
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;

/**
 *
 * @author jan
 */
public interface ManageExamBookingsService {

    void cancelExamBooking(ExamResult examResult) throws DataLayerException;

    /**
     *
     * @param student
     * @return I risultati di esami non ancora effettuati(prenotati) dello studente
     * @throws DataLayerException
     */
    List<ExamResult> getExamBookings(Student student) throws DataLayerException;
    
}
