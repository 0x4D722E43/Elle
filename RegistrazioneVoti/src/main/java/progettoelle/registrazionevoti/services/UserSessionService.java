package progettoelle.registrazionevoti.services;

import progettoelle.registrazionevoti.domain.RegisteredUser;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.user.UserRepository;

public final class UserSessionService {
        
    private final UserRepository userRepository;

    public UserSessionService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public RegisteredUser getUser(String email) throws DataLayerException {
        return userRepository.findUserByEmail(email);
    }

}
