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
    
    public void signInAppello(String codAppello) {
        db.signInStudent2App(codF, codAppello);
    }
    public void signOutAppello(String codAppello) {
        db.signOutStudent2App(codF, codAppello);
    }
    @Override
    public Studente getUser(){
        return (Studente)super.getUser();
    }
}
