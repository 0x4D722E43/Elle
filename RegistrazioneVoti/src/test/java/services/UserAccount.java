/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import progettoelle.registrazionevoti.domain.RegisteredUser;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ValidationException;
import progettoelle.registrazionevoti.services.account.ChangePasswordService;
import progettoelle.registrazionevoti.services.account.UserAccountService;
import utils.repositories4testPurpose.UserRepositoryTest;

/**
 *
 * @author mrc
 */
public class UserAccount {

    private UserRepositoryTest repository;

    public UserAccount() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        repository = new UserRepositoryTest();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getUser() {
        UserAccountService uas = new UserAccountService(repository);
        assertNotNull("User account-service is null", uas);
        try {
            RegisteredUser u = uas.getUser("alessandro.delpiero01@universitadipavia.it");
            assertNotNull(u);
            assertTrue(u.checkPassword("password"));

        } catch (DataLayerException ex) {
            fail("user not found");
        }
        fail("Not yet complete");
    }

    @Test
    public void changeInfo() {
        UserAccountService uas = new UserAccountService(repository);
        assertNotNull("User account-service is null", uas);
        try {
            RegisteredUser u = uas.getUser("alessandro.delpiero01@universitadipavia.it");
            assertNotNull(u);
            assertTrue(u.checkPassword("password"));
           //???????????????????????PPOOOORCO CHE CAZZO SERVE UPDATE USER SE NON CI SONO I SETTER
           /////////////////////////////CHE PER COSA DOVREI CAMBIARE LA PASSWORD?
           /////////////////////////////HAI FATTO UN SERVIZIO APPOSTA!!!
        } catch (DataLayerException ex) {
            fail("user not found");
        }
        fail("Not yet complete");
    }

    @Test
    public void changePassword() {        
        UserAccountService uas = new UserAccountService(repository);
        ChangePasswordService cps = new ChangePasswordService(repository);
        assertNotNull("Change password-service is null", cps);
        try {
            RegisteredUser u = uas.getUser("alessandro.delpiero01@universitadipavia.it");
            assertTrue(u.checkPassword("password"));
            cps.changePassword(u, "password", "newPassword" ,"newPassword");
            u = uas.getUser("alessandro.delpiero01@universitadipavia.it");
            assertTrue(u.checkPassword("newPassword"));
        } catch (DataLayerException ex) {
            fail("user not found");
        } catch (ValidationException ex) {
            Logger.getLogger(UserAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
