/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoelle.registrazionevoti.services.account;

import progettoelle.registrazionevoti.mail.MailException;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ValidationException;

/**
 *
 * @author jan
 */
public interface ResetPasswordService {

   

    public void resetPassword(String email) throws ValidationException, DataLayerException, MailException;
    
}
