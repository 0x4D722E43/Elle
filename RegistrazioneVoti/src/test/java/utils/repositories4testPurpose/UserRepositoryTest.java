package utils.repositories4testPurpose;

import progettoelle.registrazionevoti.domain.Professor;
import progettoelle.registrazionevoti.domain.RegisteredUser;
import progettoelle.registrazionevoti.domain.Student;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.UserRepository;

public class UserRepositoryTest implements UserRepository {

    private TestDataBase db;

    public UserRepositoryTest(TestDataBase db) {
        this.db = db;
    }

    @Override
    public void createUser(RegisteredUser user) throws DataLayerException {
        if (user instanceof Professor) {
            db.getProfessors().add((Professor)user);
        } else {
            db.getStudents().add((Student)user);
        }
    }

    @Override
    public RegisteredUser findUserById(long userID) throws DataLayerException {
        for (Student s : db.getStudents()) {
            if (s.getId().equals(userID)) {
                return s;
            }
        }
        for (Professor p : db.getProfessors()) {
            if (p.getId().equals(userID)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public RegisteredUser findUserByEmail(String email) throws DataLayerException {
        for (Student s : db.getStudents()) {
            if (s.getEmail().equalsIgnoreCase(email)) {
                return s;
            }
        }
        for (Professor p : db.getProfessors()) {
            if (p.getEmail().equalsIgnoreCase(email)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void updateUser(RegisteredUser user) throws DataLayerException {
        int index = db.getStudents().indexOf(user);
        if (index == -1) {
            index = db.getProfessors().indexOf(user);
            if(index==-1){
                throw new DataLayerException("User non presente");
            }
            db.getProfessors().remove(user);
            db.getProfessors().add((Professor)user);
            return;
        }
        db.getStudents().remove(user);
        db.getStudents().add((Student)user);
        
    }

}
