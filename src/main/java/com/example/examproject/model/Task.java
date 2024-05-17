package com.example.examproject.model;

public class Task {
    private String taskName;
    private String status;
    private String priority;
    private int id;
    private int subProjectId;

    public Task() {
    }

    public Task (String taskName, String status, String priority, int id) {
        this.taskName = taskName;
        this.status = status;
        this.priority = priority;
        this.id = id;
    }

    public Task (String taskName, String status, String priority, int id, int subProjectId) {
        this.taskName = taskName;
        this.status = status;
        this.priority = priority;
        this.id = id;
        this.subProjectId = subProjectId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
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

    public int getSubProjectId() {
        return subProjectId;
    }

    public void setSubProjectId(int subProjectId) {
        this.subProjectId = subProjectId;
    }
}
