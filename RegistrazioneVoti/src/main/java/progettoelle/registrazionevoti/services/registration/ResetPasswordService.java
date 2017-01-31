package progettoelle.registrazionevoti.services.registration;

import org.apache.commons.lang3.RandomStringUtils;
import progettoelle.registrazionevoti.domain.RegisteredUser;
import progettoelle.registrazionevoti.mail.MailException;
import progettoelle.registrazionevoti.mail.MailService;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.UserRepository;
import progettoelle.registrazionevoti.services.ValidationException;

public final class ResetPasswordService {
    
    public static final String INEXISTENT_EMAIL_MESSAGE = "Email inesistente";
    
    private final UserRepository userRepository;
    private final MailService mailService;

    public ResetPasswordService(UserRepository registeredUserRepository, MailService mailService) {
        this.userRepository = registeredUserRepository;
        this.mailService = mailService;
    }
    
    public void resetPassword(String email) throws ValidationException, DataLayerException, MailException {
        RegisteredUser user = userRepository.findUserByEmail(email);
        
        if (user == null) throw new ValidationException(INEXISTENT_EMAIL_MESSAGE);
        
        String password = RandomStringUtils.randomAlphanumeric(8);
        user.setPassword(password);
        
        String subject = "Password Dimenticata";
        String message = "La password dell' account è stata resettata. La nuova passoword è \n\n"
                + "       " + password + "\n\n"
                + "Consigliamo per motivi di sicurezza di cambiarla appena dopo aver effettuato l'accesso.\n\n"
                + "Saluti,\n "
                + "Lo Staff"; 
        
        mailService.sendEmail(email, subject, message);
        userRepository.updateUser(user);
    }

}
