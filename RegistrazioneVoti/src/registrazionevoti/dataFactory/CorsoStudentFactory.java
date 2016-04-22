/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrazionevoti.dataFactory;

import DB.DBhandler;
import registrazionevoti.dataContainer.corsi.Corso;

/**
 *
 * @author pc
 */
class CorsoStudentFactory {
    DBhandler db;
    Corso corso;
    AppelloStudentFactory appFactory;
    CorsoStudentFactory(DBhandler db) {
        this.db = db;
    }

    CorsoStudentFactory newCorso(String co) {
        corso = new Corso(db.getCorsoInfo(co).getVar("nome"),
                          Integer.parseInt(db.getCorsoInfo(co).getVar("cfu")));
        for(String app:db.getAppListOfCorso(co)){
            corso.aggiungiAppello(appFactory.newAppello(app).getAppello());
        }
        return this;               
    }

    Corso getCorso() {
        return corso;
    }
    
}
