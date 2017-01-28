package progettoelle.registrazionevoti.domain;

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
