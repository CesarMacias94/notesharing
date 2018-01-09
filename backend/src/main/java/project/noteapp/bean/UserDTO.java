package project.noteapp.bean;

public class UserDTO {
    private Integer cod_user;
    private String username;
    private String name;
    private String surname;
    private String date_of_birth;
    private String email;

    public UserDTO() {
        super();
    }

    public UserDTO(Integer cod_user, String username, String name, String surname, String date_of_birth, String email) {
        this.cod_user = cod_user;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.date_of_birth = date_of_birth;
        this.email = email;
    }

    public Integer getCod_user() {
        return cod_user;
    }

    public void setCod_user(Integer cod_user) {
        this.cod_user = cod_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
