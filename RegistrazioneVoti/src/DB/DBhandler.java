/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Utils.VarWagon;
import registrazionevoti.dataContainer.users.UserData;

/**
 *
 * @author cl410671
 */
public abstract class DBhandler {
    //User

    /**
     *
     * @param codF
     * @param pass
     * @return vero se la coppia codF e pass corrispondo a un utente valido
     */
        public abstract boolean isUser(String codF,String pass);

    /**
     *
     * @param codF
     * @return Tipo Nome Cognome DataDiNascita   (e altre dipendenti dal tipo)
     */
    public abstract VarWagon getUserInfo(String codF);
    
    //////////////////
    //Corsi e appelli
    
    /**
     *
     * @param codCorso
     * @return Nome ProfTitolare    etc
     */
        public abstract VarWagon getCorsoInfo(String codCorso);

    /**
     *
     * @param codAppello
     * @return Descrizione Data Aula    NumeroIscritti  etc
     */
    public abstract VarWagon getAppelloInfo(String codAppello);
    
    public abstract String[] getAppListOfCorso(String codCorso);

    /**
     *
     * @param codAppello
     * @return Matricole 
     */
    public abstract String[] getStuSignedApppello(String codAppello);
    
    /**
     *  Aggiunge(aggiorna) un appello al database
     *  
     * @param datiAppello
     */
    public abstract void setAppello(VarWagon datiAppello);

    /**
     *
     * @param datiAppello
     */
    public abstract void setCorso(VarWagon datiAppello);
    
    /**
     *
     * @param codF
     * @param codAppello
     */
    public abstract void signInStudent2App(String codF,String codAppello);

    /**
     *
     * @param codF
     * @param codAppello
     */
    public abstract void signOutStudent2App(String codF,String codAppello);
    
    ///////////
    //Student

    /**
     *
     * @param codf
     * @return
     */
        public abstract boolean isStudent(String codf);

    /**
     *
     * @param codF
     * @return
     */
    public abstract String[] getAppListOfStudent(String codF);

    /**
     *
     * @param codF
     * @return
     */
    public abstract String[] getCorsiListOfStudent(String codF);
}
