package progettoelle.registrazionevoti.mail;

public class MailException extends Exception {

    private static final String ERROR_MESSAGE = "Si è verificato un errore nel nostro servizio mail. Non è stato\n"
        + "possibile inviare una mail all'indirizzo in questione.\n Ci scusiamo per l'inconveniente.";
    
    public MailException() {
        super(ERROR_MESSAGE);
    }
    
}
