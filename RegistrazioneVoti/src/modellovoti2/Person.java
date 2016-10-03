/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modellovoti2;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Gianluca
 */
public class Person{
    String name,surname,CF;
    Integer mat;
    Date birth,subscription;

    Person(String name, String surname, String CF, Date birth,Date subscription) {
        this.name = name;
        this.surname = surname;
        this.CF = CF;
        this.birth = birth;
        this.subscription = subscription;
    }
    void setMat(Integer mat){
        this.mat = mat;
    }
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCF() {
        return CF;
    }

    public Integer getMat() {
        return mat;
    }

    public Date getBirth() {
        return birth;
    }

    public Date getSubscription() {
        return subscription;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.CF);
        hash = 89 * hash + Objects.hashCode(this.mat);
        hash = 89 * hash + Objects.hashCode(this.subscription);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this.CF, other.CF)) {
            return false;
        }
        if (!Objects.equals(this.mat, other.mat)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", surname=" + surname + ", CF=" + CF + ", mat=" + mat + '}';
    }
    
    
    
    
}
