/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import progettoelle.registrazionevoti.mail.MailException;
import progettoelle.registrazionevoti.mail.MailService;

/**
 *
 * @author mrc
 */
public class MailServiceTest implements MailService{
    private String lastEmail,lastSubject,lastMessage;
    @Override
    public void sendEmail(String emailAddress, String subject, String message) throws MailException {
        this.lastEmail = emailAddress;
        this.lastSubject = subject;
        this.lastMessage = message;
    }

    public String getLastEmail() {
        if(lastEmail==null) return "";
        return lastEmail;
    }

    public String getLastSubject() {
        if(lastSubject==null) return "";
        return lastSubject;
    }

    public String getLastMessage() {
        if(lastMessage==null) return "";
        return lastMessage;
    }
    
}
