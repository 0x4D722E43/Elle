/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrazionevoti.dataContainer.users;

import registrazionevoti.dataContainer.carriera.Carriera;

/**
 *
 * @author Caronte
 */
public class Studente extends UserData{
    private Carriera libretto;
    public Studente(String nome,String codF){
        super(nome,codF);
        super.setUserType(User.STUDENT);
    }
}
