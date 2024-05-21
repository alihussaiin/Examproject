package com.example.examproject.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Subproject {
    private int id;
    private int project_Id;
    private String subprojectName;
    private String description;
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    public Subproject (String subprojectName, String description, String status, LocalDate startDate, LocalDate endDate, int id, int project_Id) {

        this.subprojectName = subprojectName;
        this.description = description;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.id = id;
        this.project_Id = project_Id;
    }

    public Subproject() {

    }

    public int getId() {
        return id;
    }

    public int getProject_Id() {
        return project_Id;
    }

    public String getSubprojectName() {
        return subprojectName;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProjectId(int project_Id) {
        this.project_Id = project_Id;
    }

    public void setSubprojectName(String subprojectName) {
        this.subprojectName = subprojectName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Subproject{" +
                "id=" + id +
                ", project_Id=" + project_Id +
                ", subprojectName='" + subprojectName + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}

