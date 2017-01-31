package utils.repositories4testPurpose;

import java.util.List;
import progettoelle.registrazionevoti.domain.DegreeCourse;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.DegreeCourseRepository;

public class  DegreeCourseRepositoryTest implements DegreeCourseRepository{

    @Override
    public List<DegreeCourse> findAllDegreeCourses() throws DataLayerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
