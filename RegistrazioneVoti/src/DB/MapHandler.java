/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Utils.VarWagon;
import dataForTest.UserDataGenerator;
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
        database = UserDataGenerator.createDB();
        
    }



    public Map<String, UserData> getDatabase() {
        return database;
    }

    @Override
    public boolean isUser(String codF, String pass) {
        for (String key:database.keySet()){
            UserData user = database.get(key);
            if(user.getCodFiscale().equalsIgnoreCase(codF)&&user.getPassword().equals(pass)){
                return true;
            }
        }
        return false;
    }

    @Override
    public VarWagon getUserInfo(String codF) {
        VarWagon vars = new VarWagon();
        UserData user = database.get(codF);
        vars
                .setVar("Nome",user.getNome() )
                .setVar("CodF", user.getCodFiscale());
        return vars;
    }

    @Override
    public VarWagon getCorsoInfo(String codCorso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    }

    @Override
    public VarWagon getAppelloInfo(String codAppello) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getStuSignedApppello(String codAppello) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAppello(VarWagon datiAppello) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCorso(VarWagon datiAppello) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void signInStudent2App(String codF, String codAppello) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void signOutStudent2App(String codF, String codAppello) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isStudent(String codf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getAppListOfStudent(String codF) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getCorsiListOfStudent(String codF) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getAppListOfCorso(String codCorso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    
}
