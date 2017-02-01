/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hamcrest.Description;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.domain.RegisteredUser;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.mail.MailException;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.services.ValidationException;
import progettoelle.registrazionevoti.services.registration.RegisterProfessorService;
import progettoelle.registrazionevoti.services.registration.RegisterStudentService;
import progettoelle.registrazionevoti.services.registration.ResetPasswordService;

import utils.MailServiceTest;
import utils.repositories4testPurpose.DegreeCourseRepositoryTest;
import utils.repositories4testPurpose.FacultyRepositoryTest;
import utils.repositories4testPurpose.TestDataBase;
import utils.repositories4testPurpose.UserRepositoryTest;

/**
 *
 * @author mrc
 */
public class Registration {

    private FacultyRepositoryTest fr;
    private UserRepositoryTest ur;
    private DegreeCourseRepositoryTest dcr;
    private MailServiceTest ms;
    private TestDataBase db;

    @Before
    public void setUp() {
        db = new TestDataBase();
        db.init();
        fr = new FacultyRepositoryTest(db);
        ur = new UserRepositoryTest(db);
        dcr = new DegreeCourseRepositoryTest(db);
        ms = new MailServiceTest();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void registerStudents() {
        RegisterStudentService rss = new RegisterStudentService(dcr, ur, ms);
        List<Student> ss = getStudents();
        for (final Student s : ss) {
            try {
                rss.registerStudent(s.getEmail(), s.getName(), s.getSurname(), s.getMatriculationNumber(), dcr.findAllDegreeCourses().get(0));
            } catch (ValidationException | DataLayerException | MailException ex) {
                assertFalse(ex.getMessage(), true);
            }
            //Email di conferma
            assertThat(ms, new org.hamcrest.BaseMatcher<MailServiceTest>() {
                @Override
                public boolean matches(Object o) {
                    MailServiceTest ms = (MailServiceTest) o;
                    if (!ms.getLastEmail().equals(s.getEmail())
                            | !ms.getLastSubject().equals("Benvenuto Studente")
                            | !ms.getLastMessage().contains(s.getName())) {
                        return false;
                    }
                    return true;
                }

                @Override
                public void describeTo(Description d) {
                    d.appendText("Wrong or missing confirm mail");
                }
            });
        }
    }

    @Test
    public void registerProfessor() {
        RegisterProfessorService rps = new RegisterProfessorService(fr, ur, ms);
        List<Professor> ps = getNewProfessors();
        for (final Professor p : ps) {
            try {
                rps.registerProfessor(p.getEmail(), p.getName(), p.getSurname(), rps.getPossibleFaculties().get(0));
            } catch (ValidationException | DataLayerException | MailException ex) {
                assertFalse(ex.getMessage(), true);
            }
            //Email di conferma
            assertThat(ms, new org.hamcrest.BaseMatcher<MailServiceTest>() {
                @Override
                public boolean matches(Object o) {
                    MailServiceTest ms = (MailServiceTest) o;
                    if (!ms.getLastEmail().equals(p.getEmail())
                            | !ms.getLastSubject().equals("Benvenuto professore")
                            | !ms.getLastMessage().contains(p.getSurname())) {
                        return false;
                    }
                    return true;
                }

                @Override
                public void describeTo(Description d) {
                    d.appendText("Wrong or missing confirm mail");
                }
            });
        }
    }

    @Test
    public void resetPasswordByEmail() {
        ResetPasswordService rps = new ResetPasswordService(ur, ms);
        RegisteredUser user = null;
        try {
            user = ur.findUserByEmail("alessandro.delpiero01@universitadipavia.it");
        } catch (DataLayerException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(user);
        try {
            rps.resetPassword(user.getEmail());
        } catch (ValidationException | DataLayerException | MailException ex) {
            assertFalse(ex.getMessage(), true);
        }
        final RegisteredUser u = user;
        assertThat(ms, new org.hamcrest.BaseMatcher<MailServiceTest>() {
            @Override
            public boolean matches(Object o) {
                MailServiceTest ms = (MailServiceTest) o;
                if (!ms.getLastEmail().equals(u.getEmail())
                        | !ms.getLastSubject().equalsIgnoreCase("Password dimenticata")) {
                    return false;
                }
                return true;
            }

            @Override
            public void describeTo(Description d) {
                d.appendText("Wrong or missing confirm mail");
            }
        });
        try {
            user = ur.findUserByEmail("alessandro.delpiero01@universitadipavia.it");
        } catch (DataLayerException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
        String pass = ms.getLastMessage().split("\n\n")[1].trim();
        assertTrue("Password Not actualy reset", user.checkPassword(pass));
    }

    ///////////////////////MATERIALE PER IL TEST
    private List<Student> getStudents() {
        ArrayList<Student> out = new ArrayList<>();
        for (int i = 0; i < 42; i++) {
            Student s = new Student("student." + i + "@universitadipavia.it",
                    "nome_stu" + i, "cognome_stu" + i, "mat." + i, null);
        }
        return out;
    }

    private List<Professor> getNewProfessors() {
        ArrayList<Professor> out = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Professor p = new Professor("proffessor." + i + "@unipv.it",
                    "Nome_prof" + i, "Cognome_prof" + i, null);
        }
        return out;
    }
}
