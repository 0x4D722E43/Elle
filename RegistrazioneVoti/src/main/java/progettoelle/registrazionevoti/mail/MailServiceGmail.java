package progettoelle.registrazionevoti.mail;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.DefaultAuthenticator;

public class MailServiceGmail implements MailService {
    
    private static final Logger LOGGER = Logger.getLogger(MailServiceGmail.class.getName());
    
    private static final String SENDER_ADDRESS = "registrazionevoti@gmail.com";
    private static final String SENDER_PASSWORD = "pr0g37703ll3";
    private static final String MAIL_SERVER_NAME = "smtp.googlemail.com";
    private static final int MAIL_SERVER_PORT = 465;
    
    @Override
    public void sendEmail(String emailAddress, String subject, String message) throws MailException {
        DefaultAuthenticator gMailAuthenticator = new DefaultAuthenticator(SENDER_ADDRESS, SENDER_PASSWORD);
        
        try {
            Email email = new SimpleEmail();
            email.setHostName(MAIL_SERVER_NAME);
            email.setSmtpPort(MAIL_SERVER_PORT);
            email.setAuthenticator(gMailAuthenticator);
            email.setSSLOnConnect(true);
            email.setFrom(SENDER_ADDRESS);
            email.setSubject(subject);
            email.addTo(emailAddress);
            email.setMsg(message);
            email.setDebug(true);
            email.send();
        } catch(EmailException ex) {
            handleEmailException(ex);
        }
    }
    
    private void handleEmailException(EmailException ex) throws MailException {
        LOGGER.log(Level.SEVERE, null, ex);
        throw new MailException(); 
    }

}
