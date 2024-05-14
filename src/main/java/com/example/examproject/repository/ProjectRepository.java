package com.example.examproject.repository;

import com.example.examproject.model.Project;
import com.example.examproject.util.ConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

    @Repository
    public class ProjectRepository {


        @Value("jdbc:mysql://localhost:3306/projectmanager_db")
        private String dbUrl;

        @Value("root")
        private String dbUsername;

        @Value("Kwc52vap2qc#")
        private String dbPassword;

        public Project createProject(Project project) {
            System.out.println(project.getUsers_id());
            Connection conn = ConnectionManager.getConnection(dbUrl, dbUsername, dbPassword);
            String SQL = "INSERT INTO project (users_id, name, description, status, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?)";//de skal være de samme som de er kaldt inde i

                try (PreparedStatement ps = conn.prepareStatement(SQL)) {
                    ps.setInt(1, project.getUsers_id());
                    ps.setString(2, project.getName());
                    ps.setString(3, project.getDescription());
                    ps.setString(4, project.getStatus());
                    ps.setDate(5, Date.valueOf(project.getStartDate()));
                    ps.setDate(6, Date.valueOf(project.getEndDate()));

                    // int rowsafftected betyder at det er antallet af ændringer

                    int rowsAffected = ps.executeUpdate();
                    // og hvis det antallet af ændringer er 0 skal den kaste en fejl
                    if (rowsAffected == 0) {
                        throw new SQLException("Oprettelse af projekt mislykkedes ingen, rækker påvirket.");
                        //Creating project failed, no rows affected.
                    }
                }catch (SQLException e) {
                    e.printStackTrace();
                }
                return project; // Returnerer det lavet project
        }



        public ArrayList<Project> getAllProjects(int userId) {
            ArrayList<Project> projects = new ArrayList<>();
            String SQL = "SELECT * FROM project where users_id = ?";
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet resultSet = null;

            try {
                conn = ConnectionManager.getConnection(dbUrl, dbUsername, dbPassword);
                ps = conn.prepareStatement(SQL);
                ps.setInt(1, userId);
                resultSet = ps.executeQuery();

                while (resultSet.next()) {
                    Project project = new Project();
                    project.setId(resultSet.getInt("ID"));
                    project.setUsers_id(resultSet.getInt("USERS_ID"));
                    project.setName(resultSet.getString("NAME"));
                    project.setDescription(resultSet.getString("DESCRIPTION"));
                    project.setStatus(resultSet.getString("STATUS"));
                    project.setStartDate(resultSet.getDate("START_DATE").toLocalDate());
                    project.setEndDate(resultSet.getDate("END_DATE").toLocalDate());
                    projects.add(project);
                }
            } catch (SQLException e) {
                throw new RuntimeException("Fejl ved hentning af projekter fra databasen", e);
            }

            return projects;
        }


            public Project updateProject(Project project) {
            try (Connection conn = ConnectionManager.getConnection(dbUrl, dbUsername, dbPassword)) {
                String SQL = "UPDATE project SET USERS_ID=?, NAME=?, DESCRIPTION=?, STATUS=?, START_DATE=?, END_DATE=? WHERE ID=?";
                try (PreparedStatement ps = conn.prepareStatement(SQL)) {
                    ps.setInt(1, project.getUsers_id());
                    ps.setString(2, project.getName());
                    ps.setString(3, project.getDescription());
                    ps.setString(4, project.getStatus());
                    ps.setDate(6, Date.valueOf(project.getStartDate()));
                    ps.setDate(7, Date.valueOf(project.getEndDate()));
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
            try (Connection conn = ConnectionManager.getConnection(dbUrl, dbUsername, dbPassword)) {
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

