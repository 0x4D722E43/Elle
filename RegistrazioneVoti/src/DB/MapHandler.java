/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.util.HashMap;
import java.util.Map;
import registrazionevoti.dataContainer.users.UserData;

/**
 *
 * @author davidedelbuono
 */
public class MapHandler extends DBhandler{

    private Map<String, UserData> database;
    
    public MapHandler(){
        database = new HashMap<>();
    }
    
    @Override
    public boolean isAuser(String codF, String pass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSurname() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
