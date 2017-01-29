package progettoelle.registrazionevoti.repositories;

import java.util.List;
import progettoelle.registrazionevoti.domain.Faculty;

public interface FacultyRepository {
    
    List<Faculty> findAllFaculties() throws DataLayerException;

}
