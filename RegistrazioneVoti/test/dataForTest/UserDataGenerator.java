/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataForTest;

import java.util.HashMap;
import java.util.Map;
import registrazionevoti.dataContainer.users.Professore;
import registrazionevoti.dataContainer.users.Studente;
import registrazionevoti.dataContainer.users.UserData;

/**
 *
 * @author davidedelbuono
 */
public class UserDataGenerator {
    
    public static Map<String, UserData> createDB(){
        
        Map<String, UserData> db = new HashMap<>();
        
        UserData s1 = new Studente("studente1", "aaaa");
        UserData s2 = new Studente("studente2", "bbbb");
        UserData s3 = new Studente("studente3", "cccc");
        UserData s4 = new Studente("studente4", "dddd");
        UserData s5 = new Studente("studente5", "eeee");
        UserData s6 = new Studente("studente6", "ffff");
        UserData s7 = new Studente("studente7", "gggg");
        UserData s8 = new Studente("studente8", "hhhh");
        UserData s9 = new Studente("studente9", "iiii");
        UserData s10 = new Studente("studente10", "jjjj");
        
        UserData p1 = new Professore("prof1", "1111");
        UserData p2 = new Professore("prof2", "2222");
        UserData p3 = new Professore("prof3", "3333");
        UserData p4 = new Professore("prof4", "4444");
        UserData p5 = new Professore("prof5", "5555");
        
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
}
