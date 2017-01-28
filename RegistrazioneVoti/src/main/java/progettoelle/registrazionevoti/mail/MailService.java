package progettoelle.registrazionevoti.mail;

public interface MailService {
    
    public void sendEmail(String emailAddress, String subject, String message) throws MailException;
    
}
