package progettoelle.registrazionevoti.domain;

/**
 * E' legato a una facoltà principale.
 * Contiene dati utili allo studente (locazione ufficio, orari e sitoweb)
 * @author mrc
 */
public class Professor extends RegisteredUser {
    
    private Faculty faculty;
    private String officeLocation;
    private String officeHours;
    private String websiteLink;
    
    public Professor() {
       
    }

    public Professor(String email, String name, String surname, Faculty faculty) {
        super(email, name, surname);
        this.faculty = faculty;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public String getOfficeHours() {
        return officeHours;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }
    
    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }

    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }
    
}
