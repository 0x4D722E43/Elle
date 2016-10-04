/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modellovoti2;

import java.util.Date;

/**
 *
 * @author Gianluca
 */
public class CourseTestFactory extends AbstractFactory<CourseTest> {

    CourseTestFactory(Archive a) {
        super(a);
    }
    @Override
    protected void setParameters() {
        parList = new String[]{"course","room","start_date","end_date"};
        parClass = new Class[]{(new Course("",0)).getClass(),(new String()).getClass(),
                                (new Date()).getClass(),(new Date()).getClass()};
        super.setParameters();

    }

    @Override
    public void delete(CourseTest e) throws Exception {
        archive.remove(e);
    }

    @Override
    public void edit(CourseTest e) throws Exception {
        this.ID = e.getID();
        parameters.put("course",e.getCourse());
        parameters.put("room",e.getClassRoom());
        parameters.put("start_date", e.getStartTime());
        parameters.put("end_date",e.getEndTime());
        
    }

    @Override
    public CourseTest save() throws Exception {
        doSave();
        archive.add(product);
        return product;
    }
    void doSave(){
        product = new CourseTest((String)parameters.get("room"),(Date)parameters.get("start_date"),(Date)parameters.get("end_date"));
        if(ID == null) this.ID = archive.getNewTestID();
        product.setID(ID);
        archive.addToCourse(product,(Course)parameters.get("course"));
    }


}
