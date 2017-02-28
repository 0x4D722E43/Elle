/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoelle.registrazionevoti.services.account;

import progettoelle.registrazionevoti.domain.RegisteredUser;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ValidationException;

/**
 *
 * @author jan
 */
public interface ChangePasswordService {

    /**
     *
     * Permette il cambio di password da parte del utente,
     * a patto che questo conosca la sua vecchia password
     *
     * ValidationException è rilasciata nel caso la vecchia password sia errata
     * o che la nuova password e quella di conferma non coincidano
     *
     * @param user
     * @param oldPassword
     * @param password
     * @param confirmPassword
     * @throws ValidationException
     * @throws DataLayerException
     */
    void changePassword(RegisteredUser user, String oldPassword, String password, String confirmPassword) throws ValidationException, DataLayerException;
    
}
