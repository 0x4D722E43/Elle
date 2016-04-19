/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrazionevoti.dataContainer.users;

/**
 *  Il DataContainer sara istanziato all'avenuta identificazione 
 *  del utente e conterra tutti i dati utili all' UI
 * @author Caronte
 */
public abstract class UserData {
    private User type;
    private String nome;
    private String codFiscale;
    private String password;
    
    protected UserData(String nome,String codFiscale){
        this.nome=nome;
        this.codFiscale=codFiscale;           
    }
    

    public String getNome() {
        return nome;
    }

    public String getCodFiscale() {
        return codFiscale;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    

    
    protected void setUserType(User type){
        this.type = type;
    }
    public  User getType(){
        return this.type;
    }
}
