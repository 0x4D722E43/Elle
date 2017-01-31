package utils.repositories4testPurpose;

import java.util.List;
import progettoelle.registrazionevoti.domain.Faculty;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.FacultyRepository;

public class FacultyRepositoryTest implements FacultyRepository{

    @Override
    public List<Faculty> findAllFaculties() throws DataLayerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
