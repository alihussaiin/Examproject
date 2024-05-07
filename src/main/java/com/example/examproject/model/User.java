package com.example.examproject.model;


public class User {
    private String firstname;
    private String username;
    private Integer password;
    private int id;

    public User(String firstname, String username, Integer password, int id) {
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

    public Integer getPassword() {

        return password;
    }

    public void setPassword(Integer password) {

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
                ", firstname='" + firstname + '\'' +
                ", username='" + username + '\'' +
                ", userPassword='" + password + '\'' +
                '}';
    }

}