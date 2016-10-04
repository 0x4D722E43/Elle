/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modellovoti2;

/**
 *
 * @author Gianluca
 */
public class CourseFactory extends AbstractFactory<Course> {

    public CourseFactory(Archive a) {
        super(a);
    }
    @Override
    protected void setParameters() {
        parList = new String[]{"name","credits"};
        parClass = new Class[]{(new String()).getClass(),(new Integer(0)).getClass()};
        super.setParameters();
    }
    @Override
    public void delete(Course e) throws Exception {
        archive.remove(product);
    }

    @Override
    public void edit(Course e) throws Exception {
        this.setParameter("name", e.getName());
        this.setParameter("credits", e.getCredits());
        this.ID = e.getID();
    }

    @Override
    public Course save() throws Exception {
        doSave();
        archive.add(product);
        return product;
    }
    
    void doSave(){
        if(ID == null ) ID = archive.getNewCourseID();
        product = new Course((String)parameters.get("name"),
                (Integer)parameters.get("credits"));
        product.setID(ID);
        product.setArchive(archive);
    }
    
}
