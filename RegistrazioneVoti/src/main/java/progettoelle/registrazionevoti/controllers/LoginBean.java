/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoelle.registrazionevoti.controllers;

import javax.faces.bean.ManagedBean;
/**
 *
 * @author mrc
 */
@ManagedBean
public class LoginBean  {

    public String goStudent(){
        return "/student/home.xhtml";
    }

    public String goProfessor(){
        return "/professor/home.xhtml";
    }
}
