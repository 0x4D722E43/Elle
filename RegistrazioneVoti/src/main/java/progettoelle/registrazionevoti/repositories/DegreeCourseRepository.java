package progettoelle.registrazionevoti.repositories;

import java.util.List;
import progettoelle.registrazionevoti.domain.DegreeCourse;

public interface DegreeCourseRepository {
    
    List<DegreeCourse> findAllDegreeCourses() throws DataLayerException;

}
