/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrazionevoti.dataContainer.users;

/**
 *  
 * 
 * @author Caronte
 *  
 */
public class Professore extends UserData {

    public Professore(String nome,String codF) {
        super(nome,codF);
        super.setUserType(User.PROFESSOR);
    }


    
}
