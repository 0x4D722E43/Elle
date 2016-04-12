/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrazionevoti.dataContainer.corsi;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Caronte
 */
public class AppelloStu {
    private String descrizione;
    private Date data;
    private String aula;
    
   public  AppelloStu(String descrizione,Date data,String aula){
        this.descrizione = descrizione;
        this.data = data;
        this.aula = aula;
        
    }

    public String getDescrizione() {
        return descrizione;
    }

    public Date getData() {
        return data;
    }

    public String getAula() {
        return aula;
    }
    
}
