package bean;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "cod_user"))
public class User {
    private int cod_user;
    private String username;
    private String name;
    private String surname;
    private String date_of_birth;
    private String email;

    public User(int cod_user, String username, String name, String surname, String date_of_birth, String email) {
        this.cod_user = cod_user;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.date_of_birth = date_of_birth;
        this.email = email;
    }

    //verificare che nel db il tipo di chiave rispetti i canoni di @generatedvalue e di @generationtype
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "cod_user", unique = true, nullable = false)
    public int getCod_user() {
        return cod_user;
    }

    public void setCod_user(int cod_user) {
        this.cod_user = cod_user;
    }

    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "surname", nullable = false)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    //aggiungere nullable = false nel caso si voglia validare che l'utente sia maggiorenne
    @Column(name = "date_of_birth")
    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}