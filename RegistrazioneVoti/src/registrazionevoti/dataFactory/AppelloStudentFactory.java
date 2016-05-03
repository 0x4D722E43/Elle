/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrazionevoti.dataFactory;

import DB.DBhandler;
import java.util.Date;
import registrazionevoti.dataContainer.corsi.Appello;

/**
 *
 * @author pc
 */
class AppelloStudentFactory {
    private  DBhandler db;
    private Appello app;
    AppelloStudentFactory(DBhandler db){
        this.db = db;
    }
    AppelloStudentFactory newAppello(String codAppello) {
        app = new Appello(db.getAppelloInfo(codAppello).getVar("codAppello"),db.getAppelloInfo(codAppello).getVar("descrizione"),
                new Date(db.getAppelloInfo(codAppello).getVar("data")),
                db.getAppelloInfo(codAppello).getVar("aula"));
        return this;
    }
    Appello getAppello(){
        return app;
    }
    
}
