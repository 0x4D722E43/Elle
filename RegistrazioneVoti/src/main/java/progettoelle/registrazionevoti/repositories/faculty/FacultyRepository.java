package progettoelle.registrazionevoti.repositories.faculty;

import java.util.List;
import progettoelle.registrazionevoti.domain.Faculty;
import progettoelle.registrazionevoti.repositories.DataLayerException;

public interface FacultyRepository {
    
    List<Faculty> findAllFaculties() throws DataLayerException;

}
