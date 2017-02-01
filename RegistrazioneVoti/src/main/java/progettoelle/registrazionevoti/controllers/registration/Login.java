package progettoelle.registrazionevoti.controllers.registration;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Login  {

    public String goStudent(){
        return "/student/home.xhtml";
    }

    public String goProfessor(){
        return "/professor/home.xhtml";
    }

}
