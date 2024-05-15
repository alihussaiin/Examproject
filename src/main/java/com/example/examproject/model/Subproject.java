package com.example.examproject.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Subproject {

    private String subProjectName;
    private String description;
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    public Subproject (String subProjectName, String description, String status, LocalDate startDate, LocalDate endDate) {

        this.subProjectName = subProjectName;
        this.description = description;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Subproject () {

    }

    public String getSubProjectName () {
        return getSubProjectName();
    }

    public String getDescription() {
        return getDescription();
    }

    public String getStatus() {
        return getStatus();
    }

    public LocalDate getStartDate () {
        return getStartDate();
    }

    public LocalDate getEndDate() {
        return getEndDate();
    }

    public void setSubProjectName() {
        this.subProjectName = subProjectName;
    }

    public void setDescription() {
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
                "subProjectName='" + subProjectName + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
