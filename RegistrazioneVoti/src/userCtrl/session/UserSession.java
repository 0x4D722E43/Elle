/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userCtrl.session;

import DB.MapHandler;
import registrazionevoti.dataContainer.users.UserData;

/**
 *
 * @author cl410671
 */
public class UserSession {
    String codF,pass;
    MapHandler db;
    public UserSession(){
        this.db = new MapHandler();
    }
    public void login(String codF,String pass) throws Exception{
        this.codF = codF;
        this.pass = pass;
        if(!db.isAuser(codF, pass))
            throw new Exception("utente non valido");
    }
    public UserData getUser(){
        return db.getUser(codF, pass);
    }
    
}
