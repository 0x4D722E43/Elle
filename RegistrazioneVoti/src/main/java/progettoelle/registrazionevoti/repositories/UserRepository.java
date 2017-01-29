package progettoelle.registrazionevoti.repositories;

import progettoelle.registrazionevoti.domain.RegisteredUser;

public interface UserRepository {
    
    void createUser(RegisteredUser user) throws DataLayerException;
    
    RegisteredUser findUserById(long userID) throws DataLayerException;
    
    RegisteredUser findUserByEmail(String email) throws DataLayerException;
    
    void updateUser(RegisteredUser user) throws DataLayerException;

}
