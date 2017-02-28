/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import progettoelle.registrazionevoti.domain.RegisteredUser;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ValidationException;
import progettoelle.registrazionevoti.services.account.ChangePasswordService;
import progettoelle.registrazionevoti.services.account.ConcretePasswordService;
import progettoelle.registrazionevoti.services.account.UserAccountService;
import utils.MailServiceTest;

import utils.repositories4testPurpose.TestDataBase;
import utils.repositories4testPurpose.UserRepositoryTest;

/**
 *
 * @author mrc
 */
public class UserAccount {

    private UserRepositoryTest repository;
    private TestDataBase db;

    @Before
    public void setUp() {
        db = new TestDataBase();
        db.init();
        repository = new UserRepositoryTest(db);
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
    }

    @Test
    public void getNotExistingUser() {
        UserAccountService uas = new UserAccountService(repository);
        assertNotNull("User account-service is null", uas);
        try {
            RegisteredUser u = uas.getUser("UtenteInventato@universitadipavia.it");
            assertNull(u);
        } catch (DataLayerException ex) {
            fail("user not found");
        }
    }

    @Test
    public void changePassword() {
        UserAccountService uas = new UserAccountService(repository);
        ChangePasswordService cps = new ConcretePasswordService(repository,new MailServiceTest());
        assertNotNull("Change password-service is null", cps);
        try {
            RegisteredUser u = uas.getUser("alessandro.delpiero01@universitadipavia.it");
            cps.changePassword(u, "password", "newPassword", "newPassword");
            u = uas.getUser("alessandro.delpiero01@universitadipavia.it");
            assertTrue(u.checkPassword("newPassword"));
        } catch (DataLayerException ex) {
            fail("user not found");
        } catch (ValidationException ex) {
            fail();
        }
    }

    @Test(expected = ValidationException.class)
    public void changePasswordWithWrongOldOne() throws ValidationException {

        UserAccountService uas = new UserAccountService(repository);
        ChangePasswordService cps = new ConcretePasswordService(repository,new MailServiceTest());
        try {
            RegisteredUser u = uas.getUser("alessandro.delpiero01@universitadipavia.it");
            cps.changePassword(u, "wrongPassword", "newPassword", "newPassword");
        } catch (DataLayerException ex) {
            fail("user not found");
        }
    }

    @Test(expected = ValidationException.class)
    public void changePasswordWithWrongNewOneConfirm() throws ValidationException {

        UserAccountService uas = new UserAccountService(repository);
        ChangePasswordService cps = new ConcretePasswordService(repository,new MailServiceTest());
        try {
            RegisteredUser u = uas.getUser("alessandro.delpiero01@universitadipavia.it");
            cps.changePassword(u, "password", "newPassword", "WrongNewPassword");
        } catch (DataLayerException ex) {
            fail("user not found");
        }
    }
}
