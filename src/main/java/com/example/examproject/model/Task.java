package com.example.examproject.model;

public class Task {
    private String descriptions;
    private String status;
    private String priority;
    private int id;
    private int subProject_Id;



    public Task() {
    }

    public Task (String descriptions, String status, String priority, int id) {
        this.descriptions = descriptions;
        this.status = status;
        this.priority = priority;
        this.id = id;
    }

    public Task (String descriptions, String status, String priority, int id, int subProject_Id) {
        this.descriptions = descriptions;
        this.status = status;
        this.priority = priority;
        this.id = id;
        this.subProject_Id = subProject_Id;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubProject_Id() {
        return subProject_Id;
    }

    public void setSubProject_Id(int subProject_Id) {
        this.subProject_Id = subProject_Id;
    }
}
