/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modellovoti2;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gianluca
 */
public class StudentFactory extends AbstractFactory<Student> {

    public StudentFactory(Archive a) {
        super(a);
    }

    @Override
    public void delete(Student e) {
        archive.remove(e);
        this.setParameters();
    }

    @Override
    public void edit(Student e) throws Exception {
            this.product = e;
            this.ID = e.getMat();
            this.setParameter("name", e.getName());
            this.setParameter("surname", e.getSurname());
            this.setParameter("cf", e.getCF());
            this.setParameter("birth_date", e.getBirth());
            this.setParameter("subscription_date", e.getSubscription());   
    }
    @Override
    protected void setParameters() {
        parList = new String[]{"name","surname","cf","birth_date","subscription_date"};
        parClass = new Class[]{(new String()).getClass(),(new String()).getClass(),
            (new String()).getClass(),(new Date()).getClass(),(new Date()).getClass()};
        super.setParameters();

    }



    @Override
    public Student save() {
        doSave();
        archive.add(product);
        return product;
    }
    private void doSave(){
        product = new Student((String)parameters.get(parList[0]), (String)parameters.get(parList[1]),
                (String)parameters.get(parList[2]), (Date)parameters.get(parList[3]),(Date) parameters.get(parList[4]));
        if(ID == null) ID = archive.getNewStudentID();
        product.setMat(ID);
        product.setArchive(archive);
    }

    

    
}
