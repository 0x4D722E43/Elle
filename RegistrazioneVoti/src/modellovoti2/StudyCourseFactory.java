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
public class StudyCourseFactory extends AbstractFactory<StudyCourse> {

    StudyCourseFactory(Archive a) {
        super(a);
    }
    @Override
    protected void setParameters() {
        parList = new String[]{"name","years","faculty"};
        parClass = new Class[]{(new String()).getClass(),(new Integer(0)).getClass(),(new Faculty("")).getClass()};
        super.setParameters();

    }
    @Override
    public void delete(StudyCourse e) throws Exception {
        archive.remove(e);
    }

    @Override
    public void edit(StudyCourse e) throws Exception {
        this.ID = e.getID();
        setParameter("name", e.getName());
        setParameter("years", e.getYears());
        setParameter("Faculty", e.getFaculty());
    }

    @Override
    public StudyCourse save() throws Exception {
        doSave();
        archive.add(product);
        return product;
    }

    private void doSave() {
        product = new StudyCourse((String)parameters.get("name"), (Integer)parameters.get("years"));
        if(ID==null) this.ID = archive.getNewStudyCourseID();
        product.setID(ID);
        product.setFaculty((Faculty)parameters.get("faculty"));
        product.setArchive(archive);
    }
    
}
