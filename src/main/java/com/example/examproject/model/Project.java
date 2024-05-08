package com.example.examproject.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public class Project {
    private int id;
    private int users_id;
    private String Name;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private String status;

    public Project(int id, int users_id, String Name, String description, Date startDate, Date endDate, String status) {
        this.id = id;
        this.users_id = users_id;
        this.Name = Name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public Project() {

    }

    public int getId() {
        return id;
    }

    public int getUsers_id() {
        return users_id;
    }

    public String getName() {
        return Name;
    }

    public String getDescription() {
        return description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status='" + status + '\'' +
                '}';
    }
}