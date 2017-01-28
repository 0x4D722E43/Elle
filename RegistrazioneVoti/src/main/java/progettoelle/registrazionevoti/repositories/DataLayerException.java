package progettoelle.registrazionevoti.repositories;

public class DataLayerException extends Exception {

    private static final String ERROR_MESSAGE = "Si è verificato un errore imprevisto nel nostro database.\n"
            + "Ci scusiamo per l'inconveniente e ti inviatiamo a riprovare più tardi.";
    
    public DataLayerException() {
        super(ERROR_MESSAGE);
    }
    
}
