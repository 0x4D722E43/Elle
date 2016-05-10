/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataContainer.users;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import registrazionevoti.dataContainer.carriera.Carriera;

/**
 *
 * @author cl410671
 */
public class CarrieraTest {

    ArrayList<String> matricole;
    ArrayList<Carriera> carrieras;

    public CarrieraTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        matricole = new ArrayList<>();
        carrieras = new ArrayList<>();

        matricole.add("123456");
        matricole.add("567895");
        matricole.add("754894");

        for (String matricole1 : matricole) {

            carrieras.add(new Carriera(matricole1, 3));

        }

    }

    @After
    public void tearDown() {
    }

    @Test
    public void basic() {

        for (int i = 0; i < carrieras.size(); i++) {

            assertEquals(matricole.get(i), carrieras.get(i).getMatricola());

        }

    }

}


