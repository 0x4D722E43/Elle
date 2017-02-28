/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoelle.registrazionevoti.services.exams;

import java.util.List;
import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.domain.ExamResult;
import progettoelle.registrazionevoti.repositories.DataLayerException;

/**
 *
 * @author jan
 */
public interface GradeExamService {

    /**
     *
     * @param exam
     * @return I risultati(valutati o meno) del esame
     * @throws DataLayerException
     */
    List<ExamResult> getExamResults(Exam exam) throws DataLayerException;

    /**
     * Assegna una valutazione al risultato di un esame
     *
     * @param mark
     * @param examResult
     * @throws DataLayerException
     */
    void gradeExam(int mark, ExamResult examResult) throws DataLayerException;
    
}
