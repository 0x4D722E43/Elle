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
    private String nome;
    private int cfu;
    private ArrayList<AppelloStu> appelli;
    Corso(String nome, Integer cfu){
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

    public ArrayList<AppelloStu> getAppelli() {
        return appelli;
    }
    
}
