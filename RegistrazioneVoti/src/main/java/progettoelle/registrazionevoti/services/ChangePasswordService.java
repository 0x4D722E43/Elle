package progettoelle.registrazionevoti.services;

import progettoelle.registrazionevoti.domain.RegisteredUser;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.user.UserRepository;

public final class ChangePasswordService {
    
    private static final String INVALID_PASSWORD_MESSAGE = "La vecchia password non è corretta";
    
    private final UserRepository userRepository;

    public ChangePasswordService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public void changePassword(RegisteredUser user, String oldPassword, String password) throws ValidationException, DataLayerException {
        if (!user.checkPassword(oldPassword)) throw new ValidationException(INVALID_PASSWORD_MESSAGE);
        user.setPassword(password);
        userRepository.updateUser(user);
    }

}