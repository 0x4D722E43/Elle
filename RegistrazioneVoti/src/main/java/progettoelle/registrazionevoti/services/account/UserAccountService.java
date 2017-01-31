package progettoelle.registrazionevoti.services.account;

import progettoelle.registrazionevoti.domain.RegisteredUser;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.UserRepository;
import progettoelle.registrazionevoti.services.ValidationException;

public final class UserAccountService {
        
    private static final String INVALID_PASSWORD_MESSAGE = "La vecchia password non è corretta";
    
    private final UserRepository userRepository;

    public UserAccountService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public RegisteredUser getUser(String email) throws DataLayerException {
        return userRepository.findUserByEmail(email);
    }
    
    public void changePassword(RegisteredUser user, String oldPassword, String password) throws ValidationException, DataLayerException {
        if (!user.checkPassword(oldPassword)) throw new ValidationException(INVALID_PASSWORD_MESSAGE);
        user.setPassword(password);
        userRepository.updateUser(user);
    }

}
