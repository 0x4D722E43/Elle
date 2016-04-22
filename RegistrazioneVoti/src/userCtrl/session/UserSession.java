/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userCtrl.session;

import DB.MapHandler;
import registrazionevoti.dataContainer.corsi.Corso;
import registrazionevoti.dataContainer.users.User;
import registrazionevoti.dataContainer.users.UserData;
import registrazionevoti.dataFactory.UserFactory;

/**
 *
 * @author cl410671
 */
public class UserSession {
    String codF,pass;
    MapHandler db;
    UserFactory uFactory;
    public UserSession(){
        this.db = new MapHandler();
        this.uFactory = new UserFactory(this.db);
    }
    public void login(String codF,String pass) throws Exception{
        this.codF = codF;
        this.pass = pass;
        if(!db.isUser(codF, pass)){            
            throw new Exception("utente non valido");
        }else{
            uFactory.newUser(this.codF);
        }
    }
    public UserData getUser(){
        return uFactory.getUser();
    }
    public User getUserType(){
        return uFactory.getUserType();
    }

    
}
