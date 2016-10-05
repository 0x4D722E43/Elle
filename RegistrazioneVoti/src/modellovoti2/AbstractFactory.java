/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modellovoti2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Gianluca
 */
public abstract class AbstractFactory<E> {

    protected Archive archive;
    protected E product;
    protected HashMap<String, Object> parameters;
    protected String[] parList;
    protected Class[] parClass;
    protected Integer ID;

    AbstractFactory(Archive archive) {
        this.archive = archive;
        this.parameters = new HashMap<>();
        this.setParameters();
    }

    /**
     *
     * @param name the name of the parameter
     * @param parameter the parameter
     * @throws Exception
     */
    public void setParameter(String name, Object par) throws Exception {
        boolean notInList = true;
        for (int i = 0; i < parList.length; i++) {
            if (parList[i].equalsIgnoreCase(name)) {
                notInList = false;
                if (parClass[i].isInstance(par)) {
                    this.parameters.put(name.toLowerCase(), par);
                } else {
                    throw new Exception("Parameter not valid");
                }
            }
        }
        if (notInList) {
            throw new Exception("Parameter not valid");
        }

    }


    protected void setParameters() {
        for (String s : parList) {
            parameters.put(s, null);
        }
        this.ID = null;
    }

    /**
     * Reset the parameters setted
     */
    public void newOne() {
        this.setParameters();

    }

    /**
     *
     * @return the names of parameters
     */
    public String[] getParametersName(){
        return parList;
    }

    /**
     *
     * @return the classes of parameters
     */
    public Class[] getParametersClass(){
        return parClass;
    }
    public abstract void delete(E e) throws Exception;

    public abstract void edit(E e) throws Exception;

    public abstract E save() throws Exception;
}
