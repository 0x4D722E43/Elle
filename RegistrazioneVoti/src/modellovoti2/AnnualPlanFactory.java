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
public class AnnualPlanFactory extends AbstractFactory<AnnualPlan> {

    public AnnualPlanFactory(Archive a) {
        super(a);
    }
    @Override
    protected void setParameters() {
        parList = new String[]{"name"};
        parClass = new Class[]{(new String()).getClass()};
        super.setParameters();

    }

    @Override
    public void delete(AnnualPlan e) throws Exception {
        archive.remove(e);
    }

    @Override
    public void edit(AnnualPlan e) throws Exception {
        this.setParameter("name", e.getName());
        this.ID = e.getID();
    }

    @Override
    public AnnualPlan save() throws Exception {
        doSave();
        archive.add(product);
        return product;
    }

    private void doSave() {
        product = new AnnualPlan((String)this.parameters.get("name"));
        if(ID == null) this.ID = archive.getNewAnnualPlanID();
        product.setID(ID);
        product.setArchive(archive);
        
    }
    
}
