/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Utils.VarWagon;
import java.util.Observable;
import registrazionevoti.dataContainer.users.UserData;

/**
 *
 * @author cl410671
 */
public abstract class UICtrl extends Observable {
    protected void notifyObs(VarWagon data){
        this.setChanged();
        this.notifyObservers(data);
    }
    public abstract void setUserData(UserData user);

    public abstract void showError(uiErrors uiErrors) ;
}
