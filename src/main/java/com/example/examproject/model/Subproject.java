package com.example.examproject.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Subproject {

    private String subprojectName;
    private String description;
    private String status;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    public Subproject (String subprojectName, String description, String status, LocalDate startDate, LocalDate endDate) {

        this.subprojectName = subprojectName;
        this.description = description;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Subproject () {

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

    public LocalDate getStartDate () {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setSubProjectName() {
        this.subprojectName = subprojectName;
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
                "subprojectName='" + subprojectName + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
