/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrazionevoti.dataFactory;

import DB.DBhandler;
import registrazionevoti.dataContainer.carriera.Carriera;

/**
 *
 * @author pc
 */
class carrieraStudentFactory {
    DBhandler db;
    Carriera car;
    CorsoStudentFactory cfactory;
    carrieraStudentFactory(DBhandler db) {
        this.db = db;
        cfactory = new CorsoStudentFactory(this.db);
    }

    carrieraStudentFactory newCarriera(String codFiscale) {
        car = new Carriera(db.getUserInfo(codFiscale).getVar("matricola"),
                        Integer.getInteger(db.getUserInfo(codFiscale).getVar("annoInCorso")));
        for(String co:db.getCorsiListOfStudent(codFiscale)){
            car.aggiungiCorso(cfactory.newCorso(co).getCorso());
        }
        return this;
    }
    Carriera getCarriera(){
        return car;
    }
    
}
