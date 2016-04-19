/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userCtrl.session;

import registrazionevoti.dataContainer.corsi.Corso;
import registrazionevoti.dataContainer.users.Studente;

/**
 *
 * @author cl410671
 */
public class StudentSession extends UserSession{
    
    public void signAppello(Corso corso,int appello) {
        corso.getAppelli().get(appello).registraStudente(((Studente)super.getUser()).getLibretto().getMatricola());
        super.updateCorso(corso);
    }
}
