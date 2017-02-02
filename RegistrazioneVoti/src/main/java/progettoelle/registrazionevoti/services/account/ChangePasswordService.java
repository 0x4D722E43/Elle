package progettoelle.registrazionevoti.services.account;

import progettoelle.registrazionevoti.domain.RegisteredUser;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.UserRepository;
import progettoelle.registrazionevoti.services.BaseService;
import progettoelle.registrazionevoti.services.ValidationException;

public final class ChangePasswordService extends BaseService {
    
    private static final String INVALID_PASSWORD_MESSAGE = "La vecchia password non è corretta";
    private static final String DIFFERENT_PASSWORDS_MESSAGE = "Le password non coincidono";
    
    private final UserRepository userRepository;

    public ChangePasswordService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    /**
     *
     * Permette il cambio di password da parte del utente,
     * a patto che questo conosca la sua vecchia password
     * 
     * ValidationException è rilasciata nel caso la vecchia password sia errata
     * o che la nuova password e quella di conferma non coincidano
     * 
     * @param user
     * @param oldPassword
     * @param password
     * @param confirmPassword
     * @throws ValidationException 
     * @throws DataLayerException
     */
    public void changePassword(RegisteredUser user, String oldPassword, String password, String confirmPassword) throws ValidationException, DataLayerException {
        if (!user.checkPassword(oldPassword)) throw new ValidationException(INVALID_PASSWORD_MESSAGE);
        if (!password.equals(confirmPassword)) throw new ValidationException(DIFFERENT_PASSWORDS_MESSAGE);
        
        user.setPassword(password);
        
        userRepository.updateUser(user);
    }
    
}
