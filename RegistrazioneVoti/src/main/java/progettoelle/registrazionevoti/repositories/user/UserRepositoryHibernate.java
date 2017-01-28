package progettoelle.registrazionevoti.repositories.user;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import progettoelle.registrazionevoti.domain.RegisteredUser;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.HibernateRepository;

public class UserRepositoryHibernate extends HibernateRepository implements UserRepository {
    
    @Override
    public void createUser(RegisteredUser user) throws DataLayerException {
        initializeOperation();
        
        try {
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
        } catch(PersistenceException ex) {
            handleOperationException(ex);
        } finally {
            entityManager.close();
        }
    }

    @Override
    public RegisteredUser findUserById(long userID) throws DataLayerException {
        initializeOperation();
        RegisteredUser result = null;
        
        try {
            transaction.begin();
            result = entityManager.find(RegisteredUser.class, userID);
            transaction.commit();            
        } catch(PersistenceException ex) {
            handleOperationException(ex);
        } finally {
            entityManager.close();
        }
        
        return result;
    }

    @Override
    public RegisteredUser findUserByEmail(String email) throws DataLayerException {
        initializeOperation();
        RegisteredUser result = null;
        
        try {
            transaction.begin();
            String hql = "SELECT u FROM RegisteredUser u WHERE u.email=:email";
            result = (RegisteredUser)entityManager.createQuery(hql).setParameter("email", email).getSingleResult();    
            transaction.commit();
        } catch(NoResultException ignored){
        } catch(PersistenceException ex) {
            handleOperationException(ex);
        } finally {
            entityManager.close();
        }
        
        return result;
    }

    @Override
    public void updateUser(RegisteredUser user) throws DataLayerException {
        initializeOperation();
        
        try {
            transaction.begin();
            entityManager.merge(user);
            transaction.commit();            
        } catch(PersistenceException ex) {
            handleOperationException(ex);
        } finally {
            entityManager.close();
        }
    }
    
}
