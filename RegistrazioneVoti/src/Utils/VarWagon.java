/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.HashMap;

/**
 *
 * @author pc
 */
public class VarWagon {
    HashMap<String,String> map;

    /**
     *Una semplice classe per il passaggio di parametri tra una classe e l'altra
     */
    public VarWagon(){
        map = new HashMap<>();
    }

    /**
     *
     * @param name nome della variabile (case unsensitive)
     * @param value valore della variabile
     * @return se stesso per comodità d'utilizzo 
     */
    public VarWagon setVar(String name,String value){
        map.put(name.toUpperCase(), value);
        return this;
    }

    /**
     *
     * @param name della variabile
     * @return il valore della variabile
     */
    public String getVar(String name){
        return map.get(name.toUpperCase());
    }

    /**
     *
     * @return nome delle variabili
     */
    public String[] getVarList(){
        return (String[])map.keySet().toArray();
    }

}
