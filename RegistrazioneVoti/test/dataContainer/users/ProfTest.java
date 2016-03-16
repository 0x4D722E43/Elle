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
import registrazionevoti.dataContainer.users.Professore;

/**
 *
 * @author pc
 */
public class ProfTest {
    private Professore prof;
    private String nome="UnEgregio Tizio",cf="NGRTZ78D21R645E";
    public ProfTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        prof = new Professore(nome,cf);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void basicInfo(){
        assertEquals(nome,prof.getNome());
        assertEquals(cf,prof.getCodFiscale());
    }
}
