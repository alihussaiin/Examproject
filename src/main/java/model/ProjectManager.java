package model;

public class ProjectManager {
    private String firstname;
    private  String username;
    private String password;
    private  int user_id;

    public ProjectManager(String firstname, String username, String password, int user_id) {
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
}
