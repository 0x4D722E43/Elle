/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataContainer.users;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import registrazionevoti.dataContainer.corsi.AppelloStu;

/**
 *
 * @author cl410671
 */
public class AppelloTest {
    AppelloStu app;
    public AppelloTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        app = new AppelloStu("Prova Scritta",new Date("11/11/2016 9:30"),"Ef1");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void basic(){
        assertEquals(app.getAula(),"Ef1");
        assertEquals(app.getData().toString(),"Fri Nov 11 09:30:00 CET 2016");
        assertEquals(app.getDescrizione(),"Prova Scritta");
    }
}
