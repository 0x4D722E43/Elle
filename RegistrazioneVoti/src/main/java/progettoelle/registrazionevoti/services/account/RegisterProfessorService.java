/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoelle.registrazionevoti.services.account;

import java.util.List;
import progettoelle.registrazionevoti.domain.Faculty;
import progettoelle.registrazionevoti.mail.MailException;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ValidationException;

/**
 *
 * @author jan
 */
public interface RegisterProfessorService {

    List<Faculty> getPossibleFaculties() throws DataLayerException;

    void registerProfessor(String email, String name, String surname, Faculty faculty) throws ValidationException, DataLayerException, MailException;
    
}
