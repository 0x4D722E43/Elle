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
public class Appello {

    private String codAppello;
    private String descrizione;
    private Date data;
    private String aula;
    private ArrayList<String> matIscritti;
    private HashMap<String, Integer> voti;//<Matricola,voto>
    private String nomeCorso;

    public Appello(String codAppello, String descrizione, Date data, String aula) {
        this.descrizione = descrizione;
        this.data = data;
        this.aula = aula;
        this.codAppello = codAppello;
    }

    public Appello(String codAppello, String descrizione, Date data, String aula, HashMap<String, Integer> voti, String nomeCorso) {
        this.descrizione = descrizione;
        this.data = data;
        this.aula = aula;
        this.voti = voti;
        this.nomeCorso = nomeCorso;
        this.codAppello = codAppello;
    }

    public void setVoto(String matricola, Integer voto) throws Exception {
        if (this.matIscritti.contains(matricola)) {
            this.voti.put(matricola, voto);
        } else {
            throw new Exception("Studente non iscritto");
        }
    }

    public void registraStudente(String matricola) {
        this.matIscritti.add(matricola);
    }

    public String getCodAppello() {
        return codAppello;
    }

    
    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
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

    public String contaIscritti(){
        String iscritti = Integer.toString(matIscritti.size());
        return iscritti;
    }
    
}
