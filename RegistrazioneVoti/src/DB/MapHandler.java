package DB;

import Utils.VarWagon;
import dataForTest.UserDataGenerator;
import java.util.HashMap;
import java.util.Map;
import registrazionevoti.dataContainer.corsi.Appello;
import registrazionevoti.dataContainer.corsi.Corso;
import registrazionevoti.dataContainer.users.UserData;


/**
 *
 * @author davidedelbuono
 */
public class MapHandler extends DBhandler{

    private Map<String, UserData> databaseUser;
    private Map<String, Corso> databaseCorsi;
    
    public MapHandler(){
        databaseUser = UserDataGenerator.createDBuser();
        databaseCorsi = UserDataGenerator.createDBcorsi();
        
    }



    public Map<String, UserData> getDatabase() {
        return databaseUser;
    }

    @Override
    public boolean isUser(String codF, String pass) {
        for (String key:databaseUser.keySet()){
            UserData user = databaseUser.get(key);
            if(user.getCodFiscale().equalsIgnoreCase(codF)&&user.getPassword().equals(pass)){
                return true;
            }
        }
        return false;
    }

    @Override
    public VarWagon getUserInfo(String codF) {
        VarWagon vars = new VarWagon();
        UserData user = databaseUser.get(codF);
        vars
                .setVar("Nome",user.getNome() )
                .setVar("CodF", user.getCodFiscale());
        return vars;
    }

    @Override
    public VarWagon getCorsoInfo(String codCorso) {
        VarWagon vars = new VarWagon();
        Corso corso = databaseCorsi.get(codCorso);
        vars.setVar("codCorso", corso.getCodCorso());
        vars.setVar("Nome", corso.getNome());
        vars.setVar("cfu", Integer.toString(corso.getCfu()));
        return vars;
        
        //TODO: quando avremo collegato i corsi con i prof bisogna aggiungere .setVar("prof titolare")
   
    }

    @Override
    public VarWagon getAppelloInfo(String codAppello) {
        VarWagon vars = new VarWagon();
        Appello appello;
        for(String corso : databaseCorsi.keySet()){
            for(int i=0; i<(databaseCorsi.get(corso)).getAppelli().size();i++){
                if((databaseCorsi.get(corso)).getAppelli().get(i).getCodAppello().equalsIgnoreCase(codAppello)){
                    appello = (databaseCorsi.get(corso)).getAppelli().get(i);
                    vars.setVar("codAppello", appello.getCodAppello());
                    vars.setVar("descrizione", appello.getDescrizione());
                    vars.setVar("data", appello.getData().toString());
                    vars.setVar("aula", appello.getAula());
                    vars.setVar("numIscritti", appello.contaIscritti());
                            
                }
            }
        }
        return vars;
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
