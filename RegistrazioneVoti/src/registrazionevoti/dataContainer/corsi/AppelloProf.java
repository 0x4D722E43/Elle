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
    private HashMap<String,Integer> Voti;//<Matricola,voto>
    private String nomeMateria;
    AppelloProf(String descrizione,Date data,String aula){
        super(descrizione,data,aula);
    }
}
