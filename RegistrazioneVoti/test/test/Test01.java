/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;
import modellovoti2.AbstractFactory;
import modellovoti2.FactoriesManager;
import modellovoti2.Student;
import modellovoti2.University;



/**
 *
 * @author user
 */
public class Test01 {
    
    public static void main(String[] args) throws Exception {
        
        SimpleDateFormat sdf = new SimpleDateFormat("DD-MM-YY");
        University UniPv = new University();
        AbstractFactory af = UniPv.getFactManager().getFactory(FactoriesManager.type.STUDENT);
        af.setParameter("Name", "Giovanni");
        af.setParameter("Surname", "Capobianco");
        af.setParameter("CF", "CPBGVN91M08D268N");
        af.setParameter("Birth_Date", sdf.parse("08-08-91"));
        af.setParameter("subscription_Date", sdf.parse("01-09-2016"));
        
        Student st = (Student)af.save();
        
        System.out.println(st.getName()); 
    }
    
}
