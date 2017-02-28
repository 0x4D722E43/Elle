/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoelle.registrazionevoti.services.manageexam;

import java.util.List;
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;

/**
 *
 * @author jan
 */
public interface LoadResultsHistoryService {

    /**
     *
     * @param student
     * @return TUTTI i risultati nella carriera dello studente
     * @throws DataLayerException
     */
    List<ExamResult> getExamResultHistory(Student student) throws DataLayerException;
    
}
