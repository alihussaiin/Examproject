package com.example.examproject.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Subproject {

    private String subprojectName;
    private String description;
    private String status;
    private int id;
    private int project_id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    // Constructor med alle attributter
    public Subproject(String subprojectName, String description, String status, LocalDate startDate, LocalDate endDate, int project_id) {
        this.subprojectName = subprojectName;
        this.description = description;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.project_id = project_id;
    }

    // Constructor uden id og project_id
    public Subproject(String subprojectName, String description, String status, LocalDate startDate, LocalDate endDate) {
        this.subprojectName = subprojectName;
        this.description = description;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // No-argument constructor
    public Subproject() {}

    // Getters
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

    public int getId() {
        return id;
    }

    public int getProjectId() {
        return project_id;
    }

    // Setters
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

    public void setId(int id) {
        this.id = id;
    }

    public void setProjectId(int project_id) {
        this.project_id = project_id;
    }

    @Override
    public String toString() {
        return "Subproject{" +
                "subprojectName='" + subprojectName + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
