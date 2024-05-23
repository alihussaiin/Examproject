package com.example.examproject.model;

public class Task {
    private String description;
    private String status;
    private String priority;
    private int estimatedTime;
    private int id;
    private int subProject_Id;



    public Task() {
    }

    public Task (String description, String status, String priority, int estimatedTime, int id) {
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.estimatedTime = estimatedTime;
        this.id = id;
    }

    public Task (String description, String status, String priority, int estimatedTime, int id, int subProject_Id) {
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.estimatedTime = estimatedTime;
        this.id = id;
        this.subProject_Id = subProject_Id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    public int getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", priority='" + priority + '\'' +
                ", estimatedTime=" + estimatedTime +
                ", id=" + id +
                ", subProject_Id=" + subProject_Id +
                '}';
    }
}
