/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoelle.registrazionevoti.services.account;

import java.util.List;
import java.util.regex.Pattern;
import org.apache.commons.lang3.RandomStringUtils;
import progettoelle.registrazionevoti.domain.DegreeCourse;
import progettoelle.registrazionevoti.domain.Faculty;
import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.mail.MailException;
import progettoelle.registrazionevoti.mail.MailService;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.DegreeCourseRepository;
import progettoelle.registrazionevoti.repositories.FacultyRepository;
import progettoelle.registrazionevoti.repositories.UserRepository;
import progettoelle.registrazionevoti.services.BaseService;
import progettoelle.registrazionevoti.services.ValidationException;

/**
 *
 * @author jan
 */
public class ConcreteRegisterService extends BaseService implements RegisterProfessorService, RegisterStudentService {

    private static final String PROFESSOR_EMAIL_PATTERN = "^[a-z0-9]+\\.[a-z0-9]+@" + Pattern.quote("unipv.it") + "$";
    private static final String STUDENT_EMAIL_PATTERN = "^[a-z]+\\.[a-z]+[0-9]+@" + Pattern.quote("universitadipavia.it") + "$";
    private static final String INVALID_EMAIL_MESSAGE = "Email non valida";
    private static final String ALREADY_EXISTENT_EMAIL_MESSAGE = "Email già esistente";

    private FacultyRepository facultyRepository;
    private UserRepository userRepository;
    private MailService mailService;
    private DegreeCourseRepository degreeCourseRepository;

    public ConcreteRegisterService(FacultyRepository facultyRepository, UserRepository userRepository, MailService mailService) {
        this.facultyRepository = facultyRepository;
        this.userRepository = userRepository;
        this.mailService = mailService;
    }

    public ConcreteRegisterService(DegreeCourseRepository degreeCourseRepository, UserRepository userRepository, MailService mailService) {
        this.degreeCourseRepository = degreeCourseRepository;
        this.userRepository = userRepository;
        this.mailService = mailService;
    }

    public ConcreteRegisterService(FacultyRepository facultyRepository, DegreeCourseRepository degreeCourseRepository, UserRepository userRepository, MailService mailService) {
        this.facultyRepository = facultyRepository;
        this.degreeCourseRepository = degreeCourseRepository;
        this.userRepository = userRepository;
        this.mailService = mailService;
    }
    
    
    
    
    
    

    @Override
    public List<Faculty> getPossibleFaculties() throws DataLayerException {
        return facultyRepository.findAllFaculties();
    }

    @Override
    public void registerProfessor(String email, String name, String surname, Faculty faculty) throws ValidationException, DataLayerException, MailException {
        validateProfessorEmail(email);

        Professor professor = new Professor(email, name, surname, faculty);
        String password = RandomStringUtils.randomAlphanumeric(8);
        professor.setPassword(password);

        String subject = "Benvenuto professore";
        String message = "Gentile prof. " + surname + ",\n"
                + "  le diamo il benvenuto nel sistema di registrazione voti. La sua nuova password è \n\n"
                + "       " + password + "\n\n"
                + "Le consigliamo per motivi di sicurezza di cambiarla dopo il primo accesso.\n\n"
                + "Cordiali Saluti,\n"
                + "Lo Staff";

        mailService.sendEmail(email, subject, message);
        userRepository.createUser(professor);
    }

    private void validateStudentEmail(String email) throws ValidationException, DataLayerException {
        if (!Pattern.matches(STUDENT_EMAIL_PATTERN, email)) {
            throw new ValidationException(INVALID_EMAIL_MESSAGE);
        }
        if (userRepository.findUserByEmail(email) != null) {
            throw new ValidationException(ALREADY_EXISTENT_EMAIL_MESSAGE);
        }
    }
    
    
    

    @Override
    public List<DegreeCourse> getPossibleDegreeCourses() throws DataLayerException {
        return degreeCourseRepository.findAllDegreeCourses();
    }

    @Override
    public void registerStudent(String email, String name, String surname, String matriculationNumber, DegreeCourse degreeCourse) throws ValidationException, DataLayerException, MailException {
        validateStudentEmail(email);

        Student student = new Student(email, name, surname, matriculationNumber, degreeCourse);
        String password = RandomStringUtils.randomAlphanumeric(8);
        student.setPassword(password);

        String subject = "Benvenuto studente";
        String message = "Ciao " + name + ",\n"
                + "  ti diamo il benvenuto nel sistema di registrazione voti. La tua nuova password è \n\n"
                + "       " + password + "\n\n"
                + "Ti consigliamo per motivi di sicurezza di cambiarla dopo il primo accesso.\n\n"
                + "Cordiali Saluti,\n"
                + "Lo Staff";

        mailService.sendEmail(email, subject, message);
        userRepository.createUser(student);
    }

    private void validateProfessorEmail(String email) throws ValidationException, DataLayerException {
        if (!Pattern.matches(PROFESSOR_EMAIL_PATTERN, email)) {
            throw new ValidationException(INVALID_EMAIL_MESSAGE);
        }
        if (userRepository.findUserByEmail(email) != null) {
            throw new ValidationException(ALREADY_EXISTENT_EMAIL_MESSAGE);
        }
    }
}
