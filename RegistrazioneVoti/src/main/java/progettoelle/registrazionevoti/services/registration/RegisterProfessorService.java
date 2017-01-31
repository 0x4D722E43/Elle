package progettoelle.registrazionevoti.services.registration;

import java.util.List;
import java.util.regex.Pattern;
import org.apache.commons.lang3.RandomStringUtils;
import progettoelle.registrazionevoti.domain.Faculty;
import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.mail.MailException;
import progettoelle.registrazionevoti.mail.MailService;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.FacultyRepository;
import progettoelle.registrazionevoti.repositories.UserRepository;
import progettoelle.registrazionevoti.services.ValidationException;

public final class RegisterProfessorService {
    
    private static final String DOMAIN = "unipv.it";
    private static final String EMAIL_PATTERN = "^[a-z]+\\.[a-z]+@" + Pattern.quote(DOMAIN) + "$";
    private static final String INVALID_EMAIL_MESSAGE = "Email non valida";
    private static final String ALREADY_EXISTENT_EMAIL_MESSAGE = "Email già esistente";
    
    private final FacultyRepository facultyRepository;
    private final UserRepository userRepository;
    private final MailService mailService;

    public RegisterProfessorService(FacultyRepository facultyRepository, UserRepository userRepository, MailService mailService) {
        this.facultyRepository = facultyRepository;
        this.userRepository = userRepository;
        this.mailService = mailService;
    }

    public List<Faculty> getPossibleFaculties() throws DataLayerException {
        return facultyRepository.findAllFaculties();
    }

    public void registerProfessor(String email, String name, String surname, Faculty faculty) throws ValidationException, DataLayerException, MailException {
        validateEmail(email);
        
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
    
    private void validateEmail(String email) throws ValidationException, DataLayerException {
        if (!Pattern.matches(EMAIL_PATTERN, email)) throw new ValidationException(INVALID_EMAIL_MESSAGE);
        if (userRepository.findUserByEmail(email) != null) throw new ValidationException(ALREADY_EXISTENT_EMAIL_MESSAGE); 
    }
    
}
