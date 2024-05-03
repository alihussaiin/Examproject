package model;


public class User {
    private String firstname;
    private String username;
    private String password;
    private int id;

    public User(String firstname, String username, String password, int users_id) {
        this.firstname = firstname;
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public User() {
    }

    public String getFirstname() {

        return firstname;
    }

    public void setFirstname(String firstname) {

        this.firstname = firstname;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public int getid() {

        return id;
    }

    public void setid(int id) {

        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                ", id='" + id + '\'' +
                ", userPassword='" + password + '\'' +
                '}';
    }

}