package progettoelle.registrazionevoti.repositories.user;

import progettoelle.registrazionevoti.domain.RegisteredUser;
import progettoelle.registrazionevoti.repositories.DataLayerException;

public interface UserRepository {
    
    void createUser(RegisteredUser user) throws DataLayerException;
    
    RegisteredUser findUserById(long userID) throws DataLayerException;
    
    RegisteredUser findUserByEmail(String email) throws DataLayerException;
    
    void updateUser(RegisteredUser user) throws DataLayerException;

}
