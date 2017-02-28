/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoelle.registrazionevoti.services.manageexam;

import java.util.List;
import progettoelle.registrazionevoti.domain.Exam;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;

/**
 *
 * @author 0x4d722e43
 */
public interface BookingExamService {

    /**
     * Lo studente prenota l'esame
     * @param student
     * @param exam
     * @throws DataLayerException
     */
    void bookExam(Student student, Exam exam) throws DataLayerException;

    List<Exam> getBookableExams(Student student) throws DataLayerException;
    
}
