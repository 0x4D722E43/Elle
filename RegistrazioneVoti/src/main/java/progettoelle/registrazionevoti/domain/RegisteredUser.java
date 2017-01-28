package progettoelle.registrazionevoti.domain;

import org.apache.commons.codec.digest.DigestUtils;

public abstract class RegisteredUser extends BaseEntity {
    
    private String email;
    private String passwordHash;
    private String name;
    private String surname;
    
    public RegisteredUser() {
    }

    public RegisteredUser(String email, String name, String surname) {
        this.email = email;
        this.name = name;
        this.surname = surname;
    }
    
    public boolean checkPassword(String password) {
        String digest = DigestUtils.md5Hex(password);
        return passwordHash.equals(digest);
    }

    public void setPassword(String password) {
        passwordHash = DigestUtils.md5Hex(password);
    }

    public String getEmail() {
        return email;
    }

    public String getSurname() {
        return surname;
    }
    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "RegisteredUser{" + "email=" + email + '}';
    }
    
}
