package utils.repositories4testPurpose;

import java.util.List;
import progettoelle.registrazionevoti.domain.Faculty;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.FacultyRepository;

public class FacultyRepositoryTest implements FacultyRepository{
    private TestDataBase db;

    public FacultyRepositoryTest(TestDataBase db) {
        this.db = db;
    }
    
    
    @Override
    public List<Faculty> findAllFaculties() throws DataLayerException {
        return db.getFaculties();
    }

}
