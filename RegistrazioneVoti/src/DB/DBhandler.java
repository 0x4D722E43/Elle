/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import registrazionevoti.dataContainer.users.UserData;

/**
 *
 * @author cl410671
 */
public abstract class DBhandler {
    public abstract boolean isAuser(String codF,String pass);
    public abstract String getName();
    public abstract String getSurname();
    public abstract UserData getUser(String codF,String pass);
    
}
