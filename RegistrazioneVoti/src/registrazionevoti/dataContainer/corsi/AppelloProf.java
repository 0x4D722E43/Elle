/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrazionevoti.dataContainer.corsi;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author pc
 */
public class AppelloProf extends AppelloStu{
    private ArrayList<String> matIscritti;
    private HashMap<String,Integer> voti;//<Matricola,voto>
    private String nomeCorso;
    
    AppelloProf(String descrizione,Date data,String aula,String nomeCorso){
        super(descrizione,data,aula);
        this.nomeCorso= nomeCorso;
        this.matIscritti = new ArrayList<>();
        this.voti = new HashMap<>();
    }
    public void setVoto(String matricola,Integer voto) throws Exception{
        if(this.matIscritti.contains(matricola)){
            this.voti.put(matricola, voto);
        }else{
            throw new Exception("Studente non iscritto");
        }
    }
    public void registraStudente(String matricola){
        this.matIscritti.add(matricola);
    }

    public ArrayList<String> getMatIscritti() {
        return matIscritti;
    }

    public HashMap<String, Integer> getVoti() {
        return voti;
    }

    public String getNomeCorso() {
        return nomeCorso;
    }
    
}
