/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrazionevoti;

import DB.DBhandler;
import UI.UICtrl;
import UI.uiErrors;
import Utils.VarWagon;
import java.util.Observable;
import java.util.Observer;
import registrazionevoti.dataFactory.UserFactory;

/**
 *
 * @author cl410671
 */
public class MainController implements Observer{
    UICtrl uiController;
    DBhandler dbController;
    UserFactory factory;
    public MainController(){
        
        this.factory = new UserFactory(this.dbController);
        this.uiController.addObserver(this);
    }
    private void  Login(String cf,String pass){
        if(this.dbController.isUser(cf, pass)){
            factory.newUser(cf);
            this.uiController.setUserData(factory.getUser());
        }else{
            this.uiController.showError(uiErrors.INVALIDE_LOGIN);
        }
    }

    @Override
    public void update(Observable o, Object data) {
        VarWagon tmp = ((VarWagon)data);
        if(tmp.getVar("Source").equals("UI")){
            if(tmp.getVar("notify").equalsIgnoreCase("login")){
                this.Login(tmp.getVar("codf"), tmp.getVar("pass"));
            }
        }
    }
}
