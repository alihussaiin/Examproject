package model;

import org.springframework.web.bind.annotation.GetMapping;

public class User {
    private String firstname;
    private  String username;
    private String password;
    private  int user_id;

    public User(String firstname, String username, String password, int user_id) {
        this.firstname = firstname;
        this.username = username;
        this.password = password;
        this.user_id = user_id;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "User{" +
                ", user_id='" + user_id + '\'' +
                ", userPassword='" + password + '\'' +
                '}';
    }

    @GetMapping("/register")
    public String registerAccount() {
        return "user/doregister";
    }
}
