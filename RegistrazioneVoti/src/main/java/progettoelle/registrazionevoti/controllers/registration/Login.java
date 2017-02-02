package progettoelle.registrazionevoti.controllers.registration;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Login  {

    public String authenticateStudent(){
        return "/student/home.xhtml";
    }

    public String authenticateProfessor(){
        return "/professor/home.xhtml";
    }

}
