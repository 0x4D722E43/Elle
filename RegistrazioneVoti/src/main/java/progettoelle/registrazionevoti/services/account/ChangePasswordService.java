package progettoelle.registrazionevoti.services.account;

import progettoelle.registrazionevoti.domain.RegisteredUser;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.UserRepository;
import progettoelle.registrazionevoti.services.ValidationException;

public final class ChangePasswordService {
    
    private static final String INVALID_PASSWORD_MESSAGE = "La vecchia password non è corretta";
    private static final String DIFFERENT_PASSWORDS_MESSAGE = "Le password non coincidono";
    
    private final UserRepository userRepository;

    public ChangePasswordService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public void changePassword(RegisteredUser user, String oldPassword, String password, String confirmPassword) throws ValidationException, DataLayerException {
        if (!user.checkPassword(oldPassword)) throw new ValidationException(INVALID_PASSWORD_MESSAGE);
        if (!password.equals(confirmPassword)) throw new ValidationException(DIFFERENT_PASSWORDS_MESSAGE);
        
        user.setPassword(password);
        
        userRepository.updateUser(user);
    }
    
}
