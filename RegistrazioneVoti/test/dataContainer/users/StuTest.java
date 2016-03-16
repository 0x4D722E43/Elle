package dataContainer.users;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import registrazionevoti.dataContainer.users.Studente;

/**
 *
 * @author pc
 */
public class StuTest {
    private Studente stu;
    private String nome="UnNonAltrentanto EgregioTizio",cf="NNNGRG89T7G635O";
    public StuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        stu = new Studente(nome,cf);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void basicInfo(){
        assertEquals(nome,stu.getNome());
        assertEquals(cf,stu.getCodFiscale());
    }
}
