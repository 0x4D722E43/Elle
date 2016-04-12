/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrazionevoti.dataContainer.carriera;

import java.util.ArrayList;
import registrazionevoti.dataContainer.corsi.Corso;

/**
 * 
 *
 * @author Caronte
 */
public class Carriera {
    private String matricola;
    private int annoInCorso;
    private ArrayList<Corso> corsi;

    public Carriera(String matricola, int annoInCorso) {
        this.matricola = matricola;
        this.annoInCorso = annoInCorso;
        
    }

    public String getMatricola() {
        return matricola;
    }

    public int getAnnoInCorso() {
        return annoInCorso;
    }

    public ArrayList<Corso> getCorsi() {
        return corsi;
    }
    
    
    public void aggiungiCorso(Corso corso){
        corsi.add(corso);
    }
    
    
    
}
