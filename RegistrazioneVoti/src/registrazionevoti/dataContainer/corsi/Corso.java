/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrazionevoti.dataContainer.corsi;

import java.util.ArrayList;

/**
 *
 * @author Caronte
 */
public class Corso {
    
    private String codCorso;
    private String nome;
    private int cfu;
    private ArrayList<Appello> appelli;
    
    public Corso(String codCorso, String nome, Integer cfu){
        this.codCorso = codCorso;
        this.nome = nome;
        this.cfu = cfu;
        this.appelli = new ArrayList<>();            
    }

    public String getNome() {
        return nome;
    }

    public int getCfu() {
        return cfu;
    }

    public String getCodCorso() {
        return codCorso;
    }
    
    

    public ArrayList<Appello> getAppelli() {
        return appelli;
    }
    
    public void aggiungiAppello(Appello appello){
        appelli.add(appello);
    }
    
}
