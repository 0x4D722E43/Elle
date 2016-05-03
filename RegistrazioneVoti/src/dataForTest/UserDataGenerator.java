/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataForTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import registrazionevoti.dataContainer.corsi.Appello;
import registrazionevoti.dataContainer.corsi.Corso;
import registrazionevoti.dataContainer.users.Professore;
import registrazionevoti.dataContainer.users.Studente;
import registrazionevoti.dataContainer.users.UserData;

/**
 *
 * @author davidedelbuono
 */
public class UserDataGenerator {
    
    public static Map<String, UserData> createDBuser(){
        
        Map<String, UserData> db = new HashMap<>();
        
        UserData s1 = new Studente("studente1", "aaaa"); s1.setPassword("pw1");
        UserData s2 = new Studente("studente2", "bbbb"); s2.setPassword("pw2");
        UserData s3 = new Studente("studente3", "cccc"); s3.setPassword("pw3");
        UserData s4 = new Studente("studente4", "dddd"); s4.setPassword("pw4");
        UserData s5 = new Studente("studente5", "eeee"); s5.setPassword("pw5");
        UserData s6 = new Studente("studente6", "ffff"); s6.setPassword("pw6");
        UserData s7 = new Studente("studente7", "gggg"); s7.setPassword("pw7");
        UserData s8 = new Studente("studente8", "hhhh"); s8.setPassword("pw8");
        UserData s9 = new Studente("studente9", "iiii"); s9.setPassword("pw9");
        UserData s10 = new Studente("studente10", "jjjj"); s10.setPassword("pw10");
        
        UserData p1 = new Professore("prof1", "1111"); p1.setPassword("pw1");
        UserData p2 = new Professore("prof2", "2222"); p2.setPassword("pw2");
        UserData p3 = new Professore("prof3", "3333"); p3.setPassword("pw3");
        UserData p4 = new Professore("prof4", "4444"); p4.setPassword("pw4");
        UserData p5 = new Professore("prof5", "5555"); p5.setPassword("pw5");
        
        db.put("aaaa", s1);
        db.put("bbbb", s2);
        db.put("cccc", s3);
        db.put("dddd", s4);
        db.put("eeee", s5);
        db.put("ffff", s6);
        db.put("gggg", s7);
        db.put("hhhh", s8);
        db.put("iiii", s9);
        db.put("jjjj", s10);
        
        db.put("1111", p1);
        db.put("2222", p2);
        db.put("3333", p3);
        db.put("4444", p4);
        db.put("5555", p5);
        
        
        return db;
        
    }
    
    public static Map<String, Corso> createDBcorsi(){
        
        Map<String,Corso> db = new HashMap<>();
        
        Corso c1 = new Corso("30001","Basi di dati",6);
        c1.aggiungiAppello(new Appello("scritto",new Date("01/02/2016 9:00"),"A2"));
        c1.aggiungiAppello(new Appello("SQL",new Date("20/02/2016 12:00"),"B2"));
        c1.aggiungiAppello(new Appello("orale",new Date("01/04/2016 11:00"),"C6"));
        
        
        Corso c2 = new Corso("10001","Analisi II",9);
        c2.aggiungiAppello(new Appello("scritto",new Date("06/02/2016 9:00"),"EF1"));
        c2.aggiungiAppello(new Appello("orale",new Date("21/02/2016 11:00"),"EF4"));
        
        
        Corso c3 = new Corso("30002","IMAD",12);
        c3.aggiungiAppello(new Appello("scritto",new Date("01/02/2016 9:00"),"A2"));
        c3.aggiungiAppello(new Appello("scritto",new Date("26/04/2016 12:00"),"C1"));
        c3.aggiungiAppello(new Appello("scritto",new Date("25/12/2016 22:00"),"V7"));
        
        db.put("30001", c1);
        db.put("10001", c2);
        db.put("30002", c3);
        
        return db;
    }
}
