package model;


public class User {
    private String firstname;
    private String username;
    private String password;
    private int users_id;

    public User(String firstname, String username, String password, int users_id) {
        this.firstname = firstname;
        this.username = username;
        this.password = password;
        this.users_id = users_id;
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

    public int getUsers_id() {

        return users_id;
    }

    public void setUsers_id(int users_id) {

        this.users_id = users_id;
    }

    @Override
    public String toString() {
        return "User{" +
                ", users_id='" + users_id + '\'' +
                ", userPassword='" + password + '\'' +
                '}';
    }

}