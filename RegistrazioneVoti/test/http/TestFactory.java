/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package http;

import java.util.Date;
import registrazionevoti.dataContainer.carriera.Carriera;
import registrazionevoti.dataContainer.corsi.AppelloStu;
import registrazionevoti.dataContainer.corsi.Corso;
import registrazionevoti.dataContainer.users.Studente;

/**
 *
 * @author cl419057
 */
public class TestFactory {
    
    public static Carriera initCarriera(){
        Carriera libretto = new Carriera("657483",2);
        
        Corso c1 = new Corso("Basi di dati",6);
        c1.aggiungiAppello(new AppelloStu("scritto",new Date("01/02/2016 9:00"),"A2"));
        c1.aggiungiAppello(new AppelloStu("SQL",new Date("20/02/2016 12:00"),"B2"));
        c1.aggiungiAppello(new AppelloStu("orale",new Date("01/04/2016 11:00"),"C6"));
        libretto.aggiungiCorso(c1);
        
        Corso c2 = new Corso("Analisi II",9);
        c2.aggiungiAppello(new AppelloStu("scritto",new Date("06/02/2016 9:00"),"EF1"));
        c2.aggiungiAppello(new AppelloStu("orale",new Date("21/02/2016 11:00"),"EF4"));
        libretto.aggiungiCorso(c2);
        
        Corso c3 = new Corso("IMAD",12);
        c3.aggiungiAppello(new AppelloStu("scritto",new Date("01/02/2016 9:00"),"A2"));
        c3.aggiungiAppello(new AppelloStu("scritto",new Date("26/04/2016 12:00"),"C1"));
        c3.aggiungiAppello(new AppelloStu("scritto",new Date("25/12/2016 22:00"),"V7"));
        libretto.aggiungiCorso(c3);
        
        return libretto;
    }
    
}
