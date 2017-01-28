package progettoelle.registrazionevoti.repositories.degreecourse;

import java.util.List;
import progettoelle.registrazionevoti.domain.DegreeCourse;
import progettoelle.registrazionevoti.domain.Faculty;
import progettoelle.registrazionevoti.repositories.DataLayerException;

public interface DegreeCourseRepository {
    
    List<DegreeCourse> findDegreeCourseByFaculty(Faculty faculty) throws DataLayerException;

}
