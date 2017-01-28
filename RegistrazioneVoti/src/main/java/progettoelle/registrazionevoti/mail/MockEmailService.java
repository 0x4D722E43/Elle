package progettoelle.registrazionevoti.mail;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MockEmailService implements MailService {

    private static final Logger LOG = Logger.getLogger(MockEmailService.class.getName());
    
    @Override
    public void sendEmail(String emailAddress, String subject, String message) throws MailException {
        LOG.log(Level.INFO, "{0}\n{1}\n{2}", new Object[]{emailAddress, subject, message});
    }

}
