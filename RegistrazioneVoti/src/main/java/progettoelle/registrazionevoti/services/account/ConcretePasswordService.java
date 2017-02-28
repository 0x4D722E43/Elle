package progettoelle.registrazionevoti.services.account;

import org.apache.commons.lang3.RandomStringUtils;
import progettoelle.registrazionevoti.domain.RegisteredUser;
import progettoelle.registrazionevoti.mail.MailException;
import progettoelle.registrazionevoti.mail.MailService;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.UserRepository;
import progettoelle.registrazionevoti.services.BaseService;
import progettoelle.registrazionevoti.services.ValidationException;

public final class ConcretePasswordService extends BaseService implements ResetPasswordService, ChangePasswordService {

    private final UserRepository userRepository;
    private final MailService mailService;
    private static final String INVALID_PASSWORD_MESSAGE = "La vecchia password non è corretta";
    private static final String DIFFERENT_PASSWORDS_MESSAGE = "Le password non coincidono";
    private static final String INEXISTENT_EMAIL_MESSAGE = "Email inesistente";

    public ConcretePasswordService(UserRepository registeredUserRepository, MailService mailService) {
        this.userRepository = registeredUserRepository;
        this.mailService = mailService;
    }

    @Override
    public void resetPassword(String email) throws ValidationException, DataLayerException, MailException {
        RegisteredUser user = userRepository.findUserByEmail(email);

        if (user == null) {
            throw new ValidationException(INEXISTENT_EMAIL_MESSAGE);
        }

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

    @Override
    public void changePassword(RegisteredUser user, String oldPassword, String password, String confirmPassword) throws ValidationException, DataLayerException {
        if (!user.checkPassword(oldPassword)) {
            throw new ValidationException(INVALID_PASSWORD_MESSAGE);
        }
        if (!password.equals(confirmPassword)) {
            throw new ValidationException(DIFFERENT_PASSWORDS_MESSAGE);
        }

        user.setPassword(password);

        userRepository.updateUser(user);
    }

}
