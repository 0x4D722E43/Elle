package utils.repositories4testPurpose;

import java.util.List;
import progettoelle.registrazionevoti.domain.DegreeCourse;
import progettoelle.registrazionevoti.repositories.DataLayerException;
import progettoelle.registrazionevoti.repositories.DegreeCourseRepository;

public class  DegreeCourseRepositoryTest implements DegreeCourseRepository{
    private TestDataBase db;

    public DegreeCourseRepositoryTest(TestDataBase db) {
        this.db = db;
    }
    
    
    @Override
    public List<DegreeCourse> findAllDegreeCourses() throws DataLayerException {
        return db.getDegreeCourses();
    }
    

}
