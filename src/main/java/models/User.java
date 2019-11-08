package models;

public class User {
    private Long id;
    private String login;
    private String hashPassword;
    private String email;

    public User(Long id, String login, String password, String email) {
        this.id = id;
        this.login = login;
        this.hashPassword = password;
        this.email = email;
    }

    public User(String login, String hashPassword, String email) {
        this.login = login;
        this.hashPassword = hashPassword;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        //TODO: regex for login
        this.login = login;
        return this;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public User setHashPassword(String hashPassword) {

        this.hashPassword = hashPassword;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        //TODO: regex for email
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", hashPassword='" + hashPassword + '\'' +
                '}';
    }
}
