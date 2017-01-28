package progettoelle.registrazionevoti.domain;

public class Faculty extends BaseEntity {

    private String name;

    public Faculty() {
    
    }
    
    public Faculty(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
