package progettoelle.registrazionevoti.services;

import java.util.List;
import java.util.regex.Pattern;
import org.apache.commons.lang3.RandomStringUtils;
import progettoelle.registrazionevoti.domain.DegreeCourse;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.mail.MailException;
import progettoelle.registrazionevoti.mail.MailService;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.degreecourse.DegreeCourseRepository;
import progettoelle.registrazionevoti.repositories.faculty.FacultyRepository;
import progettoelle.registrazionevoti.repositories.user.UserRepository;

public final class RegisterStudentService {
    
    private static final String DOMAIN = "universitadipavia.it";
    private static final String EMAIL_PATTERN = "^[a-z]+\\.[a-z]+[0-9]+@" + Pattern.quote(DOMAIN) + "$";
    private static final String INVALID_EMAIL_MESSAGE = "Email non valida";
    private static final String ALREADY_EXISTENT_EMAIL_MESSAGE = "Email già esistente";
    
    private final FacultyRepository facultyRepository;
    private final DegreeCourseRepository degreeCourseRepository;
    private final UserRepository userRepository;
    private final MailService mailService;

    public RegisterStudentService(FacultyRepository facultyRepository, DegreeCourseRepository degreeCourseRepository, UserRepository userRepository, MailService mailService) {
        this.facultyRepository = facultyRepository;
        this.degreeCourseRepository = degreeCourseRepository;
        this.userRepository = userRepository;
        this.mailService = mailService;
    }
    
    public List<DegreeCourse> getPossibleDegreeCourses() throws DataLayerException {
        return degreeCourseRepository.findAllDegreeCourses();
    }

    public void registerStudent(String email, String name, String surname, String matriculationNumber, DegreeCourse degreeCourse) throws ValidationException, DataLayerException, MailException {
        if (!Pattern.matches(EMAIL_PATTERN, email)) throw new ValidationException(INVALID_EMAIL_MESSAGE);
        if (userRepository.findUserByEmail(email) != null) throw new ValidationException(ALREADY_EXISTENT_EMAIL_MESSAGE); 
        Student student = new Student(email, name, surname, matriculationNumber, degreeCourse);
        String password = RandomStringUtils.randomAlphanumeric(8);
        student.setPassword(password);
        userRepository.createUser(student);
        
        String subject = "Benvenuto studente";
        String message = "Ciao " + name + ",\n"
                + "  ti diamo il benvenuto nel sistema di registrazione voti. La tua nuova password è \n\n"
                + "       " + password + "\n\n"
                + "Ti consigliamo per motivi di sicurezza di cambiarla dopo il primo accesso.\n\n"
                + "Cordiali Saluti,\n"
                + "Lo Staff";
        mailService.sendEmail(email, subject, message);
    }
    
}
