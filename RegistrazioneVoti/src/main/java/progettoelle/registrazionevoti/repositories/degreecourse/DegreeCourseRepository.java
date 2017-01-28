package progettoelle.registrazionevoti.repositories.degreecourse;

import java.util.List;
import progettoelle.registrazionevoti.domain.DegreeCourse;
import progettoelle.registrazionevoti.repositories.DataLayerException;

public interface DegreeCourseRepository {
    
    List<DegreeCourse> findAllDegreeCourses() throws DataLayerException;

}
