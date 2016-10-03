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
class TeacherFactory extends AbstractFactory<Teacher> {

    public TeacherFactory(Archive a) {
        super(a);
    }
    @Override
    protected void setParameters() {
        parList = new String[]{"name","surname","cf","birth_date","subscription_date"};
        parClass = new Class[]{(new String()).getClass(),(new String()).getClass(),
            (new String()).getClass(),(new Date()).getClass(),(new Date()).getClass()};
        super.setParameters();
    }



    @Override
    public Teacher save() {
        doSave();
        archive.add(product);
        return product;
    }
    private void doSave(){
        product = new Teacher((String)parameters.get(parList[0]), (String)parameters.get(parList[1]),
                (String)parameters.get(parList[2]), (Date)parameters.get(parList[3]),(Date) parameters.get(parList[4]));
        if(ID == null) ID = archive.getNewStudentID();
        product.setMat(ID);
    }

    @Override
    public void delete(Teacher e) throws Exception {
        archive.remove(e);
        this.setParameters();
    }

    @Override
    public void edit(Teacher e) throws Exception {
        this.product = e;
        this.ID = e.getMat();
        this.setParameter("name", e.getName());
        this.setParameter("surname", e.getSurname());
        this.setParameter("cf", e.getCF());
        this.setParameter("birth_date", e.getBirth());
        this.setParameter("subscription_date", e.getSubscription());   
    }
    
}
