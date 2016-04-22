/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrazionevoti.dataFactory;

import DB.DBhandler;
import Utils.VarWagon;
import registrazionevoti.dataContainer.carriera.Carriera;
import registrazionevoti.dataContainer.users.Professore;
import registrazionevoti.dataContainer.users.Studente;
import registrazionevoti.dataContainer.users.User;
import registrazionevoti.dataContainer.users.UserData;

/**
 *
 * @author pc
 */
public  class UserFactory {
    UserData user;
    DBhandler db;

    /**
     *
     * @param db database handler
     */
    public UserFactory(DBhandler db){
        this.db = db;       
    };
    
    /**
     *  Crea al suo interno la classe user relativa al codF fornito
     *  interrogando il database
     * @param codF  codice fiscale
     */
    public void  newUser(String codF){
        VarWagon userInfo = db.getUserInfo(codF);
        switch(User.valueOf(userInfo.getVar("type"))){
            case STUDENT: 
                user = new Studente(userInfo.getVar("Nome"),
                        userInfo.getVar("codF"));break;
            case PROFESSOR: 
                user = new Professore(userInfo.getVar("Nome"),
                        userInfo.getVar("codF"));break;
        }
        this.constructDetails();
    }

    /**
     *
     * @return classe UserData relativa
     */
    public UserData getUser(){
        return this.user;
    }

    /**
     *
     * @return tipo di utente
     */
    public  User getUserType(){
        return this.user.getType();
    };

    protected void constructDetails() {
        switch(this.getUserType()){
            case STUDENT:
                Carriera tmp =  (new carrieraStudentFactory(this.db))
                        .newCarriera(user.getCodFiscale()).getCarriera();
                ((Studente)user).setCarriera(tmp);
                break;
        }
    }


}
