package com.example.examproject.repository;

import com.example.examproject.model.Project;
import com.example.examproject.model.User;
import com.example.examproject.util.ConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

    @Repository
    public class ProjectRepository {


        @Value("jdbc:mysql://localhost:3306/projectmanager_db")
        private String dbUrl;

        @Value("root")
        private String username;

        @Value("@H0wtomakemoney")
        private String password;

        public Project createProject(Project project) {
            try (Connection conn = ConnectionManager.getConnection(dbUrl, username, password)) {
                String SQL = "INSERT INTO project (ID, USERS_ID, NAME, DESCRIPTION, STATUS, START_DATE, END_DATE) VALUES (?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement ps = conn.prepareStatement(SQL)) {
                    ps.setInt(1, project.getId());
                    ps.setInt(2, project.getUser_id());
                    ps.setString(3, project.getName());
                    ps.setString(4, project.getDescription());
                    ps.setString(5, project.getStatus());
                    ps.setDate(6, project.getStartDate());
                    ps.setDate(7, project.getEndDate());


                    // int rowsafftected betyder at det er antallet af ændringer
                    int rowsAffected = ps.executeUpdate();
                    // og hvis det antallet af ændringer er 0 skal den kaste en fejl
                    if (rowsAffected == 0) {
                        throw new SQLException("Oprettelse af projekt mislykkedes ingen, rækker påvirket.");
                        //Creating project failed, no rows affected.
                    }
                }
                return project; // Returnerer det lavet project
            } catch (SQLException e) {
                // RuntimeException er en type Exception. Det er et interface
                throw new RuntimeException(e);
            }
        }

        public ArrayList<Project> getAllProjects() {
            ArrayList<Project> projects = new ArrayList<>();
            String SQL = "SELECT * FROM project";

            try (Connection conn = ConnectionManager.getConnection(dbUrl, username, password);
                 PreparedStatement ps = conn.prepareStatement(SQL);
                 ResultSet resultSet = ps.executeQuery()) {

                // Gentag igennem resultatsættet og opret Projekt objekter
                while (resultSet.next()) {
                    Project project = new Project();
                    project.setId(resultSet.getInt("ID"));
                    project.setUser_id(resultSet.getInt("USERS_ID"));
                    project.setName(resultSet.getString("NAME"));
                    project.setDescription(resultSet.getString("DESCRIPTION"));
                    project.setStatus(resultSet.getString("STATUS"));
                    project.setStartDate(resultSet.getDate("START_DATE"));
                    project.setEndDate(resultSet.getDate("END_DATE"));

                    // Tilføj projektet til listen
                    projects.add(project);
                }
            } catch (SQLException e) {
                throw new RuntimeException("Fejl ved hentning af projekter fra databasen", e);
            }                               // Engelsk = Error retrieving projects from the database

            return projects;
        }


        public Project updateProject(Project project) {
            try (Connection conn = ConnectionManager.getConnection(dbUrl, username, password)) {
                String SQL = "UPDATE project SET USERS_ID=?, NAME=?, DESCRIPTION=?, STATUS=?, START_DATE=?, END_DATE=? WHERE ID=?";
                try (PreparedStatement ps = conn.prepareStatement(SQL)) {
                    ps.setInt(1, project.getUser_id());
                    ps.setString(2, project.getName());
                    ps.setString(3, project.getDescription());
                    ps.setString(4, project.getStatus());
                    ps.setDate(5, project.getStartDate());
                    ps.setDate(6, project.getEndDate());
                    ps.setInt(7, project.getId());

                    //int rowsafftected betyder at det er antallet af ændringer
                    int rowsAffected = ps.executeUpdate();
                    // og hvis det antallet af ændringer er 0 skal den kaste en fejl
                    if (rowsAffected == 0) {
                        throw new SQLException("Oprettelse af projekt mislykkedes ingen, rækker påvirket");
                        //Creating project failed, no rows affected.
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } return project; // Returnere det opdateret projekt
        }


        public void deleteProject(int projectId) {
            try (Connection conn = ConnectionManager.getConnection(dbUrl, username, password)) {
                String SQL = "DELETE FROM project WHERE ID=?";
                try (PreparedStatement ps = conn.prepareStatement(SQL)) {
                    ps.setInt(1, projectId);

                    // Udfør sletningen
                    int rowsAffected = ps.executeUpdate();
                    if (rowsAffected == 0) {
                        throw new SQLException("Sletning af projekt fejlet, ingen rækker påvirket");
                        //Deleting project failed, no rows affected.
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }






    }

