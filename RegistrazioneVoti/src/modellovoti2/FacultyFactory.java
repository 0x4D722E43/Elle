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
public class FacultyFactory extends AbstractFactory<Faculty> {

    public FacultyFactory(Archive a) {
        super(a);
    }
    @Override
    protected void setParameters() {
        parList = new String[]{"name"};
        parClass = new Class[]{(new String()).getClass()};
        super.setParameters();

    }
    
    @Override
    public void delete(Faculty e) throws Exception {
        archive.remove(e);
    }

    @Override
    public void edit(Faculty e) throws Exception {
        parameters.put("name", e.getName());
        this.ID = e.getID();
    }

    @Override
    public Faculty save() throws Exception {
        doSave();
        archive.add(product);
        return product;
    }

    private void doSave() {
        product = new Faculty((String)parameters.get("name"));
        product.setID(this.ID);
       
    }
    
}
