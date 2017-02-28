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
public interface AcceptExamResultService {

    void acceptExamResult(Student student, ExamResult examResult) throws DataLayerException;

    void acknowledgeFailedExam(Student student, ExamResult examResult) throws DataLayerException;

    /**
     *
     * @param student
     * @return I risultati in attesa di rifiuto/accettazione dello studente
     * @throws DataLayerException
     */
    List<ExamResult> getExamsResults(Student student) throws DataLayerException;

    void rejectExamResult(Student student, ExamResult examResult) throws DataLayerException;
    
}
