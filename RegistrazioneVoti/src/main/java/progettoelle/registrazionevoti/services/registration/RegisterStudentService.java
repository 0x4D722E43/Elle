package progettoelle.registrazionevoti.services.registration;

import java.util.List;
import java.util.regex.Pattern;
import org.apache.commons.lang3.RandomStringUtils;
import progettoelle.registrazionevoti.domain.DegreeCourse;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.mail.MailException;
import progettoelle.registrazionevoti.mail.MailService;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.DegreeCourseRepository;
import progettoelle.registrazionevoti.repositories.UserRepository;
import progettoelle.registrazionevoti.services.ValidationException;

public final class RegisterStudentService {
    
    private static final String DOMAIN = "universitadipavia.it";
    private static final String EMAIL_PATTERN = "^[a-z]+\\.[a-z]+[0-9]+@" + Pattern.quote(DOMAIN) + "$";
    private static final String INVALID_EMAIL_MESSAGE = "Email non valida";
    private static final String ALREADY_EXISTENT_EMAIL_MESSAGE = "Email già esistente";
    
    private final DegreeCourseRepository degreeCourseRepository;
    private final UserRepository userRepository;
    private final MailService mailService;

    public RegisterStudentService(DegreeCourseRepository degreeCourseRepository, UserRepository userRepository, MailService mailService) {
        this.degreeCourseRepository = degreeCourseRepository;
        this.userRepository = userRepository;
        this.mailService = mailService;
    }
    
    public List<DegreeCourse> getPossibleDegreeCourses() throws DataLayerException {
        return degreeCourseRepository.findAllDegreeCourses();
    }

    public void registerStudent(String email, String name, String surname, String matriculationNumber, DegreeCourse degreeCourse) throws ValidationException, DataLayerException, MailException {
        validateEmail(email);
        
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
    
    private void validateEmail(String email) throws ValidationException, DataLayerException {
        if (!Pattern.matches(EMAIL_PATTERN, email)) throw new ValidationException(INVALID_EMAIL_MESSAGE);
        if (userRepository.findUserByEmail(email) != null) throw new ValidationException(ALREADY_EXISTENT_EMAIL_MESSAGE); 
    }
    
}
