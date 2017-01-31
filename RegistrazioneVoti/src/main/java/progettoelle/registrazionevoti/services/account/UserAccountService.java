package progettoelle.registrazionevoti.services.account;

import progettoelle.registrazionevoti.domain.RegisteredUser;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.UserRepository;

public final class UserAccountService {
        
    private final UserRepository userRepository;

    public UserAccountService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public RegisteredUser getUser(String email) throws DataLayerException {
        return userRepository.findUserByEmail(email);
    }
    
    public void updateUserInfo(RegisteredUser user) throws DataLayerException {
        userRepository.updateUser(user);
    }

}
